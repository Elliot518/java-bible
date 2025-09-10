package zeus.playground.thread.pool;

import java.util.concurrent.*;

/**
 * @author: KG
 * @description:
 * @date: Created in 7:24 下午 2020/7/14
 * @modified by:
 */

public class ThreadPoolExecutorDemo {
    /**
     * 每隔1秒打印的单线程
     * LinkedBlockingQueue会造成阻塞
     */
    private static void singleThreadPoolTest() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("1");
            });
        }

    }

    /**
     * 同时打印的多线程
     * SynchronousQueue并不是一个真正的队列，而是一种管理直接在线程间移交信息的机制
     */
    private static void multipleThreadPoolTest() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("1");
            });
        }

    }

    public static void main(String[] args) {
        //singleThreadPoolTest();
        multipleThreadPoolTest();
    }
}
