package zeus.playground.thread;

/**
 * @author: KG
 * @description:
 * @date: Created in 9:22 下午 2020/7/14
 * @modified by:
 */

public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId() + " Start...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId() + " End!");
    }
}
