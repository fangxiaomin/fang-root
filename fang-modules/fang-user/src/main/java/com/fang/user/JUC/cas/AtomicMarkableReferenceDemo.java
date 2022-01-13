package com.fang.user.JUC.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @author:fxm
 * @createTime:2021/12/31 15:03
 */
public class AtomicMarkableReferenceDemo {
    static AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(100,false);

    public static void main(String[] args) {
        new Thread(() ->{
            boolean marked = atomicMarkableReference.isMarked();
            System.out.println(Thread.currentThread().getName()+"\t"+"默认的修改标识" + marked);
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            atomicMarkableReference.compareAndSet(100,101,marked,!marked);
        },"t1").start();

        new Thread(() ->{
            boolean marked = atomicMarkableReference.isMarked();
            System.out.println(Thread.currentThread().getName()+"\t"+"默认的修改标识" + marked);
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            boolean b = atomicMarkableReference.compareAndSet(100, 20210308, marked, !marked);
            System.out.println(Thread.currentThread().getName()+"\t" + "操作是否成功："+ b);
            System.out.println(Thread.currentThread().getName() +"\t" + atomicMarkableReference.getReference());
        },"t2").start();
    }
}
