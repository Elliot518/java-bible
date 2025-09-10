package com.mcp.lab.java.core.api.date;

import java.time.LocalDate;

/**
 * @author: KG
 * @description: 年、月、日做参数创建任意日期
 * @date: Created in 4:27 PM 2021/3/30
 * @modified by:
 */
public class LocalDateDemo3 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2018, 2, 6);
        System.out.println("自定义日期:" + date);
    }
}

