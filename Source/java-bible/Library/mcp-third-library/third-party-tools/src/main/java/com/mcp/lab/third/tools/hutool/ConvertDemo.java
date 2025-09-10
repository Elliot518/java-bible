package com.mcp.lab.third.tools.hutool;

import cn.hutool.core.convert.Convert;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author: KG
 * @description: 类型转换工具类，用于各种类型数据的转换
 * @date: Created in 2021年06月29日 9:12 AM
 * @modified by:
 */
public class ConvertDemo {
    public static void main(String[] args) {
        // 转换为字符串
        int a = 1;
        String aStr = Convert.toStr(a);
        System.out.println(aStr);

        // 转换为指定类型数组
        String[] b = {"1", "2", "3", "4"};
        Integer[] bArr = Convert.toIntArray(b);
        Arrays.stream(bArr).forEach(System.out::println);

        // 转换为日期对象
        String dateStr = "2017-05-06";
        Date date = Convert.toDate(dateStr);
        System.out.println(date);

        // 转换为列表
        String[] strArr = {"a", "b", "c", "d"};
        List<String> strList = Convert.toList(String.class, strArr);
        strList.forEach(System.out::println);
    }
}


