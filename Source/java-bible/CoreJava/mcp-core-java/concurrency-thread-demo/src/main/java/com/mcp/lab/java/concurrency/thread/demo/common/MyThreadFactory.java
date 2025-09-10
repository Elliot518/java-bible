package com.mcp.lab.java.concurrency.thread.demo.common;

import java.util.concurrent.ThreadFactory;

/**
 * @author: KG
 * @description:
 * @date: Created in 7:45 下午 2021/9/19
 * @modified by:
 */

public class MyThreadFactory implements ThreadFactory {

    private final String threadName;

    public MyThreadFactory(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        String oldName = thread.getName();
        String newName = String.format("[%s]-%s", threadName, oldName);
        thread.setName(newName);

        return thread;
    }
}
