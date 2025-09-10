package com.mcp.lab.java.concurrency.thread.demo.pool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年09月07日 11:01 AM
 * @modified by:
 */
public class ThreadQueueTask implements Runnable {

    private static final List<String> dataList = new LinkedList<String>() {{
        add("a");
        add("b");
        add("c");
        add("d");
        add("e");
        add("1");
        add("2");
        add("3");
        add("4");
        add("5");
    }};

    @Override
    public void run() {
        while (dataList.size() > 0) {
            synchronized (this) {
                String data = dataList.get(0);
                dataList.remove(0);

                System.out.println("线程:" + Thread.currentThread().getName() + ", 数据：" + data);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 创建 2 个数据级的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(new ThreadQueueTask());
        threadPool.submit(new ThreadQueueTask());
        threadPool.submit(new ThreadQueueTask());
    }
}
