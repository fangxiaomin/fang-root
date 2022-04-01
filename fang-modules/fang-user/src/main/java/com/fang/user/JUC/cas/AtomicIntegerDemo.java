package com.fang.user.JUC.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author:fxm   countDownLatch  的使用 确保 线程能够彻底完成
 * @createTime:2021/12/31 10:49
 */

class MyNumber {
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addPlus(){
        atomicInteger.incrementAndGet();
    }
}
public class AtomicIntegerDemo {

    public static final int SIZE = 5000 ;


    public static void main(String[] args) throws InterruptedException {

//        MyNumber myNumber = new MyNumber();
        CountDownLatch countDownLatch = new CountDownLatch(SIZE);
        for (int i = 1; i <= SIZE ; i++) {
            new Thread(() ->{
                try {
//                    AtomicIntegerDemo.atomicAdd();
                    AtomicIntegerDemo.add();
//                    for (int j = 1; j <= 1000 ; j++) {
//                        myNumber.addPlus();
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
//        System.out.println(Thread.currentThread().getName() + "   result :" + myNumber.atomicInteger.get());
    }

    public static Integer atomicAdd(){
        MyNumber myNumber = new MyNumber();
        for (int j = 1; j <= 1000 ; j++) {
                        myNumber.addPlus();
        }
        System.out.println(myNumber.atomicInteger.get());
        return  myNumber.atomicInteger.get();
    }
    public static Integer add(){
        Integer cnt = 0 ;
        for (int j = 1; j <= 1000 ; j++) {
             cnt ++ ;
        }
        if( cnt != 1000){
            System.out.println( cnt);
        }
        return cnt;
    }

}
