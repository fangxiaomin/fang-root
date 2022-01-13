package com.fang.user.JUC.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author:fxm   自旋锁
 * @createTime:2021/12/30 17:30
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock(){
        System.out.println(Thread.currentThread().getName() + " \t" + " ----come in ");
        //自旋锁
        while (!atomicReference.compareAndSet(null, Thread.currentThread())) { }
        System.out.println(Thread.currentThread().getName() +"\t" + " -----持有锁成功");
    }
    public void MyUnLock(){
        atomicReference.compareAndSet(Thread.currentThread(),null);
        System.out.println(Thread.currentThread().getName() +"\t" + " -----释放锁成功");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() ->{
            spinLockDemo.myLock();
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLockDemo.MyUnLock();
        },"t1").start();

        new Thread(() ->{
            spinLockDemo.myLock();
            spinLockDemo.MyUnLock();
        },"t2").start();

    }
}
