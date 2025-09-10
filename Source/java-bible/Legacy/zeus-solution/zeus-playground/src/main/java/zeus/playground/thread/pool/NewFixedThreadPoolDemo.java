package zeus.playground.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: KG
 * @description: create a thread pool to create 5 threads in pool
 * @date: Created in 上午11:24 2018/10/27
 * @modified by:
 */

public class NewFixedThreadPoolDemo {

    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        int threadNum = 5;
        int actualThreadNum = 10;
        ExecutorService es = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < actualThreadNum; i++) {
            es.submit(task);
        }
    }
}
