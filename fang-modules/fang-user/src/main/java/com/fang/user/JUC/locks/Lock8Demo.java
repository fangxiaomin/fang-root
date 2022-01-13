package com.fang.user.JUC.locks;

import lombok.val;

import java.util.concurrent.TimeUnit;

/**
 * @author:fxm   synchronized  s锁的是  资源对象，同一时间只能有一个方法被执行
 * @createTime:2021/12/24 10:11
 */

class Phone{
    public synchronized void sendEmail(){
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(" ----------------sendEmail");
    }
    public synchronized void sendSMS(){
        System.out.println(" ----------------sendSMS");
    }
}

public class Lock8Demo {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() ->{
            phone.sendEmail();
        },"a").start();

        try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() ->{
            phone.sendSMS();
        },"b").start();


    }
}
