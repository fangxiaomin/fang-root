package com.fang.user.JUC.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:fxm
 * @createTime:2021/12/27 10:01
 * 隐式锁指的是可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁，这样的锁就叫做可重入锁。
 * 简单说：在一个synchronized修饰的方法或者代码块的内部调用本类的其他synchronized修复的方法或者代码块时，是永远可以得到锁的。
 */
public class ReEntryLockDemo {


    public synchronized void m1(){
        System.out.println(" --- m1");
        m2();
    }
    public synchronized void m2(){
        System.out.println(" --- m2");
        m3();
    }
    public synchronized void m3(){
        System.out.println(" --- m3");
    }


    static Object objectLock = new Object();

    public static void main(String[] args) {
//        new ReEntryLockDemo().m1();
    Lock lock = new ReentrantLock();
    new Thread(() ->{
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " ----- w外层");
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " ----- 内层");
            } finally {
//                lock.unlock();
            }
        } finally {
            lock.unlock();
        }
    },"t1").start();

    //  上面有一个未释放锁。导致下面的线程无法进入
    new  Thread(() ->{
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " ----- 2222");
        } finally {
            lock.unlock();
        }
    },"t2").start();

    }

    public static void synaBlock(String[] args) {
        new Thread(() ->{
            synchronized (objectLock){
                System.out.println(" --- 外层");
                synchronized (objectLock){
                    System.out.println(" --- 中层");
                    synchronized (objectLock){
                        System.out.println(" --- 内层");
                    }
                }
            }
        },"t1").start();
    }
}
