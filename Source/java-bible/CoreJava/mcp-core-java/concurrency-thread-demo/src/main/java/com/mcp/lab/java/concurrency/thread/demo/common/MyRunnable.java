package com.mcp.lab.java.concurrency.thread.demo.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: KG
 * @description:
 * @date: Created in 7:15 下午 2021/9/19
 * @modified by:
 */
public class MyRunnable implements Runnable {

    private String name;

    public MyRunnable(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(ThreadLogFormat.startLine(Thread.currentThread().getName(), name));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ThreadLogFormat.endLine(Thread.currentThread().getName(), name));
    }
}
