package zeus.playground.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: KG
 * @description:
 * @date: Created in 7:49 下午 2020/7/17
 * @modified by:
 */

public class CachedThreadPoolDemo1 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            try {
                System.out.println("Runnable1 begin "
                        + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("A");
                System.out.println("Runnable1   end "
                        + System.currentTimeMillis());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                System.out.println("Runnable2 begin "
                        + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("B");
                System.out.println("Runnable2   end "
                        + System.currentTimeMillis());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

    }
}












