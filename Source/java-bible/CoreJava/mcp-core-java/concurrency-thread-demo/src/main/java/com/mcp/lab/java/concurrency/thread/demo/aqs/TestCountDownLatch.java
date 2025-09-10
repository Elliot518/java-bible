package com.mcp.lab.java.concurrency.thread.demo.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @author: KG
 * @description: CountDownLatch计数器等待子线程都并行执行完毕之后再执行主线程(统计子线程任务最大耗时)
 * @date: Created in 15:32 2022/5/22
 * @modified by:
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        //计数器为10
        CountDownLatch countDownLatch = new CountDownLatch(10);

        //将CountDownLatch对象传递到线程的run()方法中，当每个线程执行完毕run()后就将计数器减1
        MyThread myThread = new MyThread(countDownLatch);
        long start = System.currentTimeMillis();
        //创建10个线程，并执行
        for (int i = 0; i < 10; i++) {
            new Thread(myThread).start();
        }
        try {
            //主线程(main)等待：等待的计数器为0；即当CountDownLatch中的计数器为0时，Main线程才会继续执行。
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }
}

class MyThread implements Runnable {
    private CountDownLatch latch;

    public MyThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //每个子线程执行完毕后，触发一次countDown()，即计数器减1
            latch.countDown();
        }
    }
}







