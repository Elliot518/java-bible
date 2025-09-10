package com.mcp.lab.third.tools.hutool;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * @author: KG
 * @description: 日期时间工具类，定义了一些常用的日期时间操作方法
 * @date: Created in 2021年06月29日 9:27 AM
 * @modified by:
 */
public class DateUtilDemo {
    public static void main(String[] args) {
        // 当前时间
        Date date = DateUtil.date();
        System.out.println("当前时间: " + date);

        // Calendar转Date
        date = DateUtil.date(Calendar.getInstance());
        System.out.println("Calendar转Date: " + date);

        // 时间戳转Date
        date = DateUtil.date(System.currentTimeMillis());
        System.out.println("时间戳转Date: " + date);

        // 自动识别格式转换
        String dateStr = "2017-03-01";
        date = DateUtil.parse(dateStr);
        System.out.println("自动识别格式转换: " + date);

        // 自定义格式化转换
        date = DateUtil.parse(dateStr, "yyyy-MM-dd");
        System.out.println("自定义格式化转换: " + date);

        // 格式化输出日期
        String format = DateUtil.format(date, "yyyy-MM-dd");
        System.out.println("格式化输出日期: " + format);

        // 获得年的部分
        int year = DateUtil.year(date);
        // 获得月份，从0开始计数
        int month = DateUtil.month(date);
        System.out.printf("Year: %d, Month: %d \n", year, month);

        // 获取某天的开始、结束时间
        Date beginOfDay = DateUtil.beginOfDay(date);
        Date endOfDay = DateUtil.endOfDay(date);
        System.out.printf("Begin of Day: %tc， End of Day: %tc%n", beginOfDay, endOfDay);

        // 计算偏移后的日期时间
        Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
        System.out.println("计算偏移后的日期时间: " + newDate);
        Date newDate2 = DateUtil.offset(date, DateField.DAY_OF_MONTH, -2);
        System.out.println("计算偏移后的日期时间2: " + newDate2);

        // 计算日期时间之间的偏移量
        long betweenDay = DateUtil.between(date, newDate, DateUnit.DAY);
        System.out.println("计算日期时间之间的偏移量: " + betweenDay);
    }
}
