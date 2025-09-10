package com.mcp.lab.java.core.api.date;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 * @author: KG
 * @description: 周期性事件
 * @date: Created in 4:36 PM 2021/3/30
 * @modified by:
 */
public class LocalDateDemo5 {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();

        LocalDate date2 = LocalDate.of(1990, 3, 30);
        MonthDay birthday = MonthDay.of(date2.getMonth(), date2.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(date1);

        if (currentMonthDay.equals(birthday)) {
            System.out.println("是你的生日");
        } else {
            System.out.println("你的生日还没有到");
        }

    }
}
