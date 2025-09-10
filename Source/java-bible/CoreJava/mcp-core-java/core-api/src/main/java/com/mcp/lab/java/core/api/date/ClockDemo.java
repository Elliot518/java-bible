package com.mcp.lab.java.core.api.date;

import java.time.Clock;

/**
 * @author: KG
 * @description: Java 8的Clock时钟类
 * 替代System.currentTimeInMillis()和TimeZone.getDefault()
 * @date: Created in 4:58 PM 2021/3/30
 * @modified by:
 */
public class ClockDemo {
    public static void main(String[] args) {
        // Returns the current time based on your system clock and set to UTC.
        Clock clock = Clock.systemUTC();
        System.out.println("Clock: " + clock.millis());
        System.out.println("Current Time: " + System.currentTimeMillis());

        // Returns time based on system clock zone
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + defaultClock.millis());

    }
}

