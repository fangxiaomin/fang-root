package com.fang.user.JUC.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author:fxm
 * @createTime:2021/12/31 15:28
 */


class BankAccount{
    String bankName ="ccb";

    //更新的对象属性必须使用 public volatile修饰符
    public volatile int money = 0;
    //因为对象的属性修改类型原子类都是抽象类，所以每次使用都必须使用静态方法newUpdater()创建一个更新器，且需要设置想要的更新的类和属性
    AtomicIntegerFieldUpdater fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(BankAccount.class,"money");
    public void transfer( BankAccount bankAccount ){
        fieldUpdater.incrementAndGet(bankAccount);
    }
}
public class AtomicIntegerFieldUpdaterDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 1; i <= 1000 ; i++) {
            new Thread(() ->{
                try {
                    bankAccount.transfer(bankAccount);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t" +"----bankAccount: " + bankAccount.money);

    }
}
