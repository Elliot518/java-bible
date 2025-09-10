package com.mcp.lab.java.core.api.date;

import java.time.LocalDate;

/**
 * @author: KG
 * @description: Java 8中获取年、月、日信息
 * @date: Created in 4:24 PM 2021/3/30
 * @modified by:
 */
public class LocalDateDemo2 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.println("year:" + year);
        System.out.println("month:" + month);
        System.out.println("day:" + day);

    }
}

