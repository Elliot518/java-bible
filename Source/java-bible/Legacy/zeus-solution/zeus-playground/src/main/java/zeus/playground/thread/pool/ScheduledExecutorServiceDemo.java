package zeus.playground.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: KG
 * @description:
 * @date: Created in 上午11:45 2018/10/27
 * @modified by:
 */

public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
        int threadSize = 10;
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(threadSize);
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);
    }
}
