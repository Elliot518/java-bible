package com.mcp.lab.java.core.api.date;

import java.time.Month;
import java.time.YearMonth;

/**
 * @author: KG
 * @description: 如何表示信用卡到期这类固定日期，答案就在YearMonth
 * @date: Created in 5:18 PM 2021/3/30
 * @modified by:
 */
public class YearMonthDemo {
    public static void main(String[] args) {
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2019, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
    }
}
