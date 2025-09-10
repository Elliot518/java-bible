package com.mcp.lab.java.core.api.date;

import java.time.LocalTime;

/**
 * @author: KG
 * @description: Java 8中获取当前时间
 * @date: Created in 4:40 PM 2021/3/30
 * @modified by:
 */
public class LocalTimeDemo {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println("获取当前的时间,不含有日期: " + time);

    }
}
