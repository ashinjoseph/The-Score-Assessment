package org.the.score.common.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class DateUtils {
    private final static String FINAMETRICA_UI_DATE_FORMAT = "MMM d, YYYY";
    private final static String FINAMETRICA_API_DATE_FORMAT = "yyyy-MM-dd";
    private final static String FINAMETRICA_COMPACT_DATE_FORMAT = "MM/dd/yyyy";

    public static String formatDate(String value){
        DateTimeFormatter originFormat = DateTimeFormat.forPattern(FINAMETRICA_API_DATE_FORMAT);
        DateTime time = originFormat.parseDateTime(value);
        DateTimeFormatter destFormat = DateTimeFormat.forPattern(FINAMETRICA_UI_DATE_FORMAT);
        return destFormat.print(time);
    }

    public static String formatDateFromISOtoText(String value){
        DateTime time = ISODateTimeFormat.dateTimeParser().withOffsetParsed().parseDateTime(value);
        DateTimeFormatter destFormat = DateTimeFormat.forPattern(FINAMETRICA_UI_DATE_FORMAT);
        return destFormat.print(time);
    }

    public static String formatDateFromISOtoCompactDate(String value){
        DateTime time = ISODateTimeFormat.dateTimeParser().withOffsetParsed().parseDateTime(value);
        DateTimeFormatter destFormat = DateTimeFormat.forPattern(FINAMETRICA_COMPACT_DATE_FORMAT);
        return destFormat.print(time);
    }

    public static String formatDateForUIConfig(DateTime value){
        DateTimeFormatter destFormat = DateTimeFormat.forPattern(FINAMETRICA_COMPACT_DATE_FORMAT);
        return destFormat.print(value);
    }

    public static DateTime dateFromISO(String value){
        return ISODateTimeFormat.dateTimeParser().withOffsetParsed().parseDateTime(value);
    }
}
