package org.the.score.common.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.Duration;
import org.joda.time.Seconds;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class EnvironmentVariables {
    private static final Logger logger = LogManager.getLogger(EnvironmentVariables.class);
    private static final String PROPERTY_FILE_PATH = "stormaws.properties";

    private static final String DATE_FORMAT = "dd/M/yyyy HH:mm:ss";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    private static final EnvironmentVariables instance = new EnvironmentVariables();
    private Properties properties;

    public EnvironmentVariables() {
        try (InputStream input = EnvironmentVariables.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_PATH)) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException ex) {
            logger.error(String.format("There's an error reading %s properties file.", PROPERTY_FILE_PATH), ex);
        }
    }

    public static EnvironmentVariables getInstance() {
        return instance;
    }

    public static String getBaseUrl() {

        return String.format(instance.properties.getProperty("awsurl"));
    }

    public static String getPrId() {
        return System.getProperty("pr-id");
    }

    public static boolean isRetriesEnabled() {
        return System.getProperty("enableRetries") != null;
    }

    public static boolean isHeadlessEnabled() {
        return System.getProperty("headless") != null;
    }

    public static float getDiffThreshold() {
        return Float.parseFloat(instance.properties.getProperty("finametrica.diffThreshold"));
    }

    public static String getApiBaseUrl() {
        return instance.properties.getProperty("finametrica.baseApiUrl");
    }

    public static Integer getRunId() {
        if (System.getProperty("runId") != null)
            return Integer.valueOf(System.getProperty("runId"));
        else return null;
    }

    public static Integer getWaitTimeout() {
        return Integer.parseInt(instance.properties.get("aws.waitTimeout").toString());
    }

    public static Integer getPollingTime() {
        return Integer.parseInt(instance.properties.get("aws.poolingTime").toString());
    }

    public static String getBrowser() {
        return System.getProperty("browser").toUpperCase(Locale.ROOT);
    }

    public static URL getHubUrl() throws MalformedURLException {
        return new URL(System.getProperty("hubUrl"));
    }

    public static String getJiraReference() {
        return System.getProperty("jira");
    }

    public static String getTestRailUsername() {
        return System.getProperty("testRail.username");
    }

    public static String getTestRailPassword() {
        return System.getProperty("testRail.password");
    }

    public static String formatDate(Date date) {
        return dateFormat.format(date);
    }

    public static String formatDuration(Duration duration) {
        if (duration.getStandardSeconds() >= Seconds.ONE.getSeconds()) {
            PeriodFormatter formatter = new PeriodFormatterBuilder()
                    .appendHours()
                    .appendSuffix("h")
                    .appendMinutes()
                    .appendSuffix("m")
                    .appendSeconds()
                    .appendSuffix("s")
                    .toFormatter();
            return formatter.print(duration.toPeriod());
        } else return "1s";
    }
}
