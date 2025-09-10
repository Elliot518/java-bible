package com.mcp.lab.java.core.api.date;

import java.time.Instant;

/**
 * @author: KG
 * @description: Java 8中获取当前的时间戳
 * @date: Created in 5:27 PM 2021/3/30
 * @modified by:
 */
public class InstantDemo {
    public static void main(String[] args) {
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp.toEpochMilli());
    }
}

