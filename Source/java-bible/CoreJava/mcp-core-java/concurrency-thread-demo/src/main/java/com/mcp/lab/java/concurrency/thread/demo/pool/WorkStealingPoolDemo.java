package com.mcp.lab.java.concurrency.thread.demo.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: KG
 * @description: 创建一个抢占式执行的线程池(任务执行顺序不确定)
 * @date: Created in 17:39 2022/4/17
 * @modified by:
 */
public class WorkStealingPoolDemo {
    public static void workStealingPool() {
        // 创建线程池
        ExecutorService threadPool = Executors.newWorkStealingPool();

        // 执行任务
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(() -> {
                System.out.println(index + " 被执行,线程名:" + Thread.currentThread().getName());
            });
        }
        // 确保任务执行完成
        while (!threadPool.isTerminated()) {
        }
    }

    public static void main(String[] args) {
        workStealingPool();
    }
}


