package com.mcp.lab.java.concurrency.thread.demo.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: KG
 * @description: readLock():  读锁， 可以共享读, 但不能共享写。
 * writeLock(): 写锁, 独占锁, 只能独占, 不能被其它线程读或写。
 * @date: Created in 16:09 2022/5/22
 * @modified by:
 */
public class TestReadWriteLock {
    // 读写锁
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        TestReadWriteLock test = new TestReadWriteLock();
        //t1线程
        new Thread(() -> {
            //读操作
            test.myRead(Thread.currentThread());
            //写操作
            test.myWrite(Thread.currentThread());
        }, "t1").start();

        //t2线程
        new Thread(() -> {
            //读操作
            test.myRead(Thread.currentThread());
            //写操作
            test.myWrite(Thread.currentThread());
        }, "t2").start();

    }

    //用读锁来锁定读操作
    public void myRead(Thread thread) {
        rwl.readLock().lock();
        try {
            for (int i = 0; i < 10000; i++) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "===读操作完毕===");
        } finally {
            rwl.readLock().unlock();
        }
    }

    //用写锁来锁定写操作
    public void myWrite(Thread thread) {
        rwl.writeLock().lock();
        try {
            for (int i = 0; i < 10000; i++) {
                System.out.println(thread.getName() + "正在进行写操作");
            }
            System.out.println(thread.getName() + "===写操作完毕===");
        } finally {
            rwl.writeLock().unlock();
        }
    }
}
