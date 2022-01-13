package com.fang.user.JUC.locks;

import java.util.concurrent.TimeUnit;

/**
 * @author:fxm
 * @createTime:2021/12/27 10:32
 */
public class DeadLock {

    static Object lockA = new Object();
    static Object lockB = new Object();

    public static void main(String[] args) {
        new Thread(() ->{
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "\t" + " a线程获得A锁，期待获得B锁");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "\t" + " 获得B锁");
                }
            }
        },"a").start();

        new Thread(() ->{
            synchronized (lockB){
            System.out.println(Thread.currentThread().getName() + "\t"  + " b线程获得B锁，期待获得A锁");
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (lockA){
                System.out.println(Thread.currentThread().getName() + "\t"  + " 获得A锁");
            }
        }
        },"b").start();
    }
}
