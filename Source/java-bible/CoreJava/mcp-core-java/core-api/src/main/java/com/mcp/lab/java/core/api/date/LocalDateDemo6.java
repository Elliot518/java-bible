package com.mcp.lab.java.core.api.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author: KG
 * @description: week/month/year calculation
 * @date: Created in 4:46 PM 2021/3/30
 * @modified by:
 */
public class LocalDateDemo6 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期为: " + today);
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后的日期为: " + nextWeek);
        System.out.println("----------------------------------------------------------");

        LocalDate previousMonth = today.minus(1, ChronoUnit.MONTHS);
        System.out.println("一月前的日期: " + previousMonth);

        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        System.out.println("一月后的日期: " + nextMonth);

        System.out.println("----------------------------------------------------------");

        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("一年前的日期: " + previousYear);

        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("一年后的日期: " + nextYear);
    }
}
