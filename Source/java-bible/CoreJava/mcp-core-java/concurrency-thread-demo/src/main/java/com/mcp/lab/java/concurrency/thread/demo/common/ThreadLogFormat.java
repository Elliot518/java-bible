package com.mcp.lab.java.concurrency.thread.demo.common;

/**
 * @author: KG
 * @description:
 * @date: Created in 7:36 下午 2021/9/19
 * @modified by:
 */

public class ThreadLogFormat {
    public static String startLine(String threadName, String arg) {
        return String.format("[%s] - %s begin at: %s", threadName, arg, System.currentTimeMillis());
    }

    public static String endLine(String threadName, String arg) {
        return String.format("[%s] - %s end at: %s", threadName, arg, System.currentTimeMillis());
    }
}

