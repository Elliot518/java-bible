package zeus.playground.thread.pool;

import zeus.playground.thread.MyTask;

import java.util.concurrent.*;

/**
 * @author: KG
 * @description:
 * @date: Created in 9:21 下午 2020/7/14
 * @modified by:
 */

public class RejectThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(10),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + " is discarded");
                    }
                });
        for (int i=0;i<Integer.MAX_VALUE;i++) {
            es.submit(task);
            Thread.sleep(10);
        }
    }
}
