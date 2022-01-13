package com.fang.user.JUC;

import org.springframework.retry.backoff.ThreadWaitSleeper;

import java.util.concurrent.TimeUnit;

/**
 * @author:fxm  t1 线程  main  线程
 * @createTime:2021/12/21 17:35
 */
public class Thread1 {
    public static void main(String[] args) {
        Thread a= new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in: \t  "
                    + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));
            while (true) {

            }
        }, "a");

        //  false  是用户线程
        a.setDaemon(true);
        a.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName() + " \t" + " -----tast is over" );
    }
}
