package com.mcp.lab.java.core.api.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: KG
 * @description:
 * @date: Created in 5:29 PM 2021/3/30
 * @modified by:
 */
public class DateTimeStringConvertDemo {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // 日期转字符串
        String str = date.format(format1);

        System.out.println("日期转换为字符串:" + str);

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // 字符串转日期
        LocalDate date2 = LocalDate.parse(str, format2);
        System.out.println("日期类型:" + date2);
        LocalDateTime date3 = LocalDateTime.parse(str, format2);
        System.out.println("日期时间类型:" + date3);
    }
}
