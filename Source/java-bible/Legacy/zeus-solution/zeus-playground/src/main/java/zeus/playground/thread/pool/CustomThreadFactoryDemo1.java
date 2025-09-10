package zeus.playground.thread.pool;

import org.jetbrains.annotations.NotNull;
import zeus.playground.thread.MyTask;

import java.util.concurrent.*;

/**
 * @author: KG
 * @description:
 * @date: Created in 8:22 下午 2020/7/17
 * @modified by:
 */

public class CustomThreadFactoryDemo1 {
    public static void main(String[] args) {
        int threadNum = 5;

        MyTask task = new MyTask();

        // 自定义线程工厂
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(@NotNull Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        System.out.println("create " + t);
                        return t;
                    }
                });

        for (int i = 0; i < threadNum; i++) {
            es.submit(task);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
