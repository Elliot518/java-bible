package com.mcp.lab.java.core.api.date;

import java.time.LocalDate;

/**
 * @author: KG
 * @description: Java 8中检查闰年
 * @date: Created in 5:20 PM 2021/3/30
 * @modified by:
 */
public class LeapYearDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        if (today.isLeapYear()) {
            System.out.println("This year is Leap year");
        } else {
            System.out.println("This year is not a Leap year");
        }

        LocalDate date1 = today.minusYears(1);
        if (date1.isLeapYear()) {
            System.out.println("Last year is Leap year");
        } else {
            System.out.println("Last year is not a Leap year");
        }
    }
}
