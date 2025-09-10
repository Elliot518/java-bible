package com.mcp.lab.java.core.api.date;

import java.time.LocalTime;

/**
 * @author: KG
 * @description: 小时计算
 * @date: Created in 4:42 PM 2021/3/30
 * @modified by:
 */
public class LocalTimeDemo2 {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(3);
        System.out.println("三个小时后的时间为: " + newTime);
    }
}
