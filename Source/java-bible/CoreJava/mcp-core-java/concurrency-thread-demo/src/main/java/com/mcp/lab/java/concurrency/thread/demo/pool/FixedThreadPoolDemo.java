package com.mcp.lab.java.concurrency.thread.demo.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: KG
 * @description: 创建一个固定大小的线程池，可控制并发的线程数，超出的线程会在队列中等待
 * @date: Created in 9:31 下午 2021/9/6
 * @modified by:
 */

public class FixedThreadPoolDemo {
    public static void fixedThreadPool() {
        // 创建 2 个数据级的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        // 创建任务
        Runnable runnable = () -> System.out.println("任务被执行,线程:" + Thread.currentThread().getName());

        /*
         * 线程池执行任务(一次添加 4 个任务)
         * 执行任务的方法有两种:submit 和 execute
         */

        // 执行方式 1:submit
        threadPool.submit(runnable);

        // 执行方式 2:execute
        for (int i=0;i<10;i++) {
            threadPool.execute(() -> {
                System.out.println("Executing thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println("Thread pool end...");
    }

    public static void main(String[] args) {
        fixedThreadPool();
    }
}
