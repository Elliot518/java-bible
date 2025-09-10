package zeus.playground.thread.basic;

import zeus.playground.model.User;

/**
 * @author: KG
 * @description:
 * @date: Created in 上午10:08 2018/4/28
 * @modified by:
 */

public class StopThreadUnsafe {
    public static User user = new User();

    public static class ChangeObjectUnsafeThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    int id = (int)(System.currentTimeMillis() / 1000);
                    user.setId(id);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(id));

                    Thread.yield();
                }
            }
        }
    }

    public static class ReadObjectUnsafeThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    if (user.getId() != Integer.parseInt(user.getName())) {
                        System.out.println("Not identical: " + user.toString());
                    }
                }

                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        new ReadObjectUnsafeThread().start();

        while (true) {
            Thread t = new ChangeObjectUnsafeThread();
            t.start();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.stop();
        }
    }
}
