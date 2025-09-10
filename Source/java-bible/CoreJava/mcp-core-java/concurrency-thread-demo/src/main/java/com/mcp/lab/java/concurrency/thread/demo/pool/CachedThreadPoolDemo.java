package com.mcp.lab.java.concurrency.thread.demo.pool;

import com.mcp.lab.java.concurrency.thread.demo.common.MyRunnable;
import com.mcp.lab.java.concurrency.thread.demo.common.MyThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: KG
 * @description:
 * @date: Created in 7:14 下午 2021/9/19
 * @modified by:
 */

public class CachedThreadPoolDemo {
    public static void main(String[] args) throws Exception {
        MyThreadFactory threadFactory = new MyThreadFactory("micro component");
        ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);

        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable(String.valueOf(i + 1)));
        }

        Thread.sleep(5000);
        System.out.println("------------------------------------------------");

        for (int i = 5; i < 10; i++) {
            executorService.execute(new MyRunnable(String.valueOf(i + 1)));
        }
    }
}
