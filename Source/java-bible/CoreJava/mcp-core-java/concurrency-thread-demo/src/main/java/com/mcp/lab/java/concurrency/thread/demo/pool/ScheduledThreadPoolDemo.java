package com.mcp.lab.java.concurrency.thread.demo.pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: KG
 * @description: 创建一个可以执行延迟任务的线程池
 * @date: Created in 17:32 2022/4/17
 * @modified by:
 */
public class ScheduledThreadPoolDemo {
    public static void scheduledThreadPool() {
        // 创建线程池
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);

        // 添加定时执行任务(1s 后执行)
        System.out.println("添加任务,时间:" + new Date());
        threadPool.schedule(() -> {
            System.out.println("任务被执行,时间:" + new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        scheduledThreadPool();
    }
}
