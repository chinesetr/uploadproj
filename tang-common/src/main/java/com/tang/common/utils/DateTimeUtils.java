package com.tang.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;

public class DateTimeUtils {
    private static final DateTimeFormatter TANG_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy MMM dd HH:mm");
    private static final DateTimeFormatter RONG_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy MMM dd HH:mm a");
    private static final DateTimeFormatter A_DATETIME_FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

    public static LocalDateTime parseTime(String timestr){
	return LocalDateTime.parse(timestr,TANG_DATETIME_FORMATTER);
    }
    
    /**
     * 
     */
    public static String toString(LocalDateTime ldt){
	return A_DATETIME_FORMATTER.format(ldt);
    }
    
}
