package com.mcp.lab.java.core.api.date;

import java.time.LocalDate;

/**
 * @author: KG
 * @description:
 * @date: Created in 4:29 PM 2021/3/30
 * @modified by:
 */
public class LocalDateDemo4 {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();

        LocalDate date2 = LocalDate.of(2021, 3, 30);

        if (date1.equals(date2)) {
            System.out.println("时间相等");
        } else {
            System.out.println("时间不等");
        }

    }
}
