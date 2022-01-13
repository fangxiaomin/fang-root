package com.fang.user.JUC.volatiles;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:fxm
 * @createTime:2021/12/30 13:33
 */
public class VolatileNoAtomicDemo {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        for (int i = 1; i <= 10 ; i++) {
            new Thread(() ->{
                for (int j = 1; j <= 1000; j++) {
                    myNumber.addPlusplus();
                }
            },String.valueOf(i)).start();
        }
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println(Thread.currentThread().getName() + "\t " + myNumber.number);

    }
}

class MyNumber{
    volatile int number = 0;
    public void addPlusplus(){
        number++;
    }
}
