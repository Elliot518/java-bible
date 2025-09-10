package com.mcp.lab.java.core.api.date;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author: KG
 * @description: 计算两个日期之间的天数和月数
 * @date: Created in 5:24 PM 2021/3/30
 * @modified by:
 */
public class LocalDateCalcDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        LocalDate future = LocalDate.of(2021, 7, 2);

        Period periodToNextJavaRelease = Period.between(today, future);
        System.out.println("Months left between today and future : "
                + periodToNextJavaRelease.getMonths());

    }
}

