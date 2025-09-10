package com.mcp.lab.java.core.api.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author: KG
 * @description: Java 8中处理时区
 * ZoneId来处理特定时区，ZoneDateTime类来表示某时区下的时间。
 * 在Java 8以前都是 GregorianCalendar类来做的。
 * @date: Created in 5:13 PM 2021/3/30
 * @modified by:
 */
public class ZoneDemo {
    public static void main(String[] args) {
        // Date and time with timezone in Java 8
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime dateTime1 = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(dateTime1, america);
        System.out.println("Current date and time: " + dateTime1);
        System.out.println("Current date and time in a particular timezone: " + dateAndTimeInNewYork);
    }
}

