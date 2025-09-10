package zeus.playground.thread.basic;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午1:41 2018/5/1
 * @modified by:
 */

/**
 * 通过实现Runnable接口来创建线程
  */
public class RunnableDemo implements Runnable {
    private int i;

    // run方法同样是线程执行体
    @Override
    public void run() {
        for (; i < 100; i++) {
            // 当线程类实现Runnable接口时，
            // 如果想获取当前线程，只能用Thread.currentThread()方法。
            System.out.println(Thread.currentThread().getName()
                    + "  " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            if (i == 20) {
                RunnableDemo st = new RunnableDemo();
                // 通过new Thread(target , name)方法创建新线程
                new Thread(st, "新线程1").start();
                new Thread(st, "新线程2").start();
            }
        }
    }
}

