package com.mcp.lab.java.concurrency.thread.demo.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: KG
 * @description: 创建单个线程数的线程池，它可以保证先进先出的执行顺序
 * @date: Created in 17:23 2022/4/17
 * @modified by:
 */
public class SingleThreadPoolDemo {
    public static void singleThreadExecutor() {
        // 创建线程池
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        // 执行任务
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(() -> {
                System.out.println(index + ":任务被执行");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) {
        singleThreadExecutor();
    }
}
