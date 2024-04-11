package org.the.score.common.test;


import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.the.score.common.actions.CommonActions;
import org.the.score.common.utils.FilesUtility;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public BaseTest() {
        super();
    }


    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected final static int SHORT_WAIT_TIME = 1000;
    protected final static int LONG_WAIT_TIME = 5000;
    protected final static String APP = "C:/Ashin/Appium/theScore.apk";
    protected final static String APPIUM = "http://localhost:4723/";

    protected String Execution_Environment;

    protected AndroidDriver driver;
    protected CommonActions actions;


    public BaseTest(AndroidDriver driver) {
        this.driver = driver;
        this.actions = new CommonActions(driver);
    }
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {

        FilesUtility.init();

    }

    @BeforeTest
    public void setUp(ITestContext context) throws MalformedURLException {

        Execution_Environment = context.getCurrentXmlTest().getParameter("execution-env");
        DesiredCapabilities caps;

        switch (Execution_Environment) {
            case "saucelab":
                caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("appium:app", "storage:filename=mda-2.0.1-22.apk");  // The filename of the mobile app
                caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
                caps.setCapability("appium:platformVersion", "12.0");
                caps.setCapability("appium:automationName", "UiAutomator2");
                MutableCapabilities sauceOptions = new MutableCapabilities();
                sauceOptions.setCapability("username", "oauth-ashinjoseph.joseph-e773a");
                sauceOptions.setCapability("accessKey", "23075c50-48d5-4839-a235-90d7a8b77e3b");
                sauceOptions.setCapability("build", "appium-build-GW13D");
                sauceOptions.setCapability("name", "<your test name>");
                sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
                caps.setCapability("sauce:options", sauceOptions);

            default:
                caps = new DesiredCapabilities();
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                caps.setCapability(MobileCapabilityType.APP, APP);

        }
        driver = new AndroidDriver(new URL(APPIUM), caps);


    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
