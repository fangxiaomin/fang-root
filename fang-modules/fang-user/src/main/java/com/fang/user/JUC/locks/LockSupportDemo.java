package com.fang.user.JUC.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:fxm  三种让线程唤醒的方法
 * @createTime:2021/12/27 13:43
 */
public class LockSupportDemo {
    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    /**
     * @Description:   park()   unpark()  方法
     * 
     **/
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() +" \t" +" -----进来了");
            LockSupport.park();//  阻塞
            System.out.println(Thread.currentThread().getName() +" \t" +" -----被唤醒");
        }, "a");
        a.start();
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

        Thread b = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() +" \t" +" -----通知了");
            LockSupport.unpark(a);
        }, "b");
        b.start();

    }

    public static void lockWaitSignal() {
        new Thread(() ->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() +" \t" +" -----进来了");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +" \t" +" -----被唤醒");
            } finally {
                lock.unlock();
            }

        },"A").start();

        new Thread(() ->{
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() +" \t" +" -----通知");
            } finally {
                lock.unlock();
            }
        },"B").start();

    }

    public static void synchronizedWaitNotify() {
        new Thread(() ->{
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName() +" \t" +" -----进来了");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +" \t" +" -----被唤醒");
            }
        },"A").start();

        new Thread(() ->{
            synchronized (objectLock){
                objectLock.notify();
                System.out.println(Thread.currentThread().getName()+ " \t" +" -----通知");
            }
        },"B").start();

    }
}
