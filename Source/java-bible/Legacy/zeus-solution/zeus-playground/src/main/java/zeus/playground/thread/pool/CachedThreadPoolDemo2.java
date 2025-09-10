package zeus.playground.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: KG
 * @description:
 * @date: Created in 8:01 下午 2020/7/17
 * @modified by:
 */

public class CachedThreadPoolDemo2 {
    public static void main(String[] args) {
        int threadNum = 5;

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadNum; i++) {
            executorService.execute(() -> System.out.println("run!"));
        }

    }
}

