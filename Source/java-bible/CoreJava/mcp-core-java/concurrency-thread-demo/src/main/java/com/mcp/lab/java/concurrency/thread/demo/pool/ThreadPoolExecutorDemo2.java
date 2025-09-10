package com.mcp.lab.java.concurrency.thread.demo.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: KG
 * @description: ThreadPoolExecutor Demo
 * @date: Created in 12:22 下午 2021/9/4
 * @modified by:
 */

public class ThreadPoolExecutorDemo2 {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new NameTreadFactory();

        // 创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 100,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), threadFactory);
        // 执行任务
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(() -> {
                System.out.println(index + " 被执行,线程名:" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    static class NameTreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

}
