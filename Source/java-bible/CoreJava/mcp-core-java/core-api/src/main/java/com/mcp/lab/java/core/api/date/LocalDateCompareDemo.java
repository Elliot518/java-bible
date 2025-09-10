package com.mcp.lab.java.core.api.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author: KG
 * @description: Java8中判断日期的前后
 * @date: Created in 5:06 PM 2021/3/30
 * @modified by:
 */
public class LocalDateCompareDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        LocalDate date1 = LocalDate.of(2018, 2, 6);
        compareDateByToday(date1);

        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        compareDateByToday(yesterday);

        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        compareDateByToday(tomorrow);
    }

    private static void compareDateByToday(LocalDate date) {
        LocalDate today = LocalDate.now();

        if (date.isAfter(today)) {
            System.out.println("之后的日期: " + date);
        } else if (date.isBefore(today)) {
            System.out.println("之前的日期: " + date);
        } else {
            System.out.println("今天的日期: " + date);
        }
    }
}
