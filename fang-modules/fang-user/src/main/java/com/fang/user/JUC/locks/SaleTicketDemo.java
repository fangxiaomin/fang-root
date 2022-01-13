package com.fang.user.JUC.locks;

import com.google.common.collect.PeekingIterator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:fxm
 * @createTime:2021/12/24 17:46
 */


class Tickket
{
    private int number = 50;
    //默认的是 非公平锁，非公平容易全部被某一个线程抢走，分配不均使用公平锁分配平均一点，   加  true 就是公平锁
    private Lock lock = new ReentrantLock(true);
    public void sale(){
        lock.lock();
        try {
            if(number > 0 ){
                System.out.println(Thread.currentThread().getName() + "\t 卖出了第： " + (number--) +" \t 还剩下："+ number);
            }
        } finally {
            lock.unlock();
        }
    }
}
public class SaleTicketDemo {
    public static void main(String[] args) {
        Tickket tickket = new Tickket();
        new Thread(() ->{ for (int i = 1; i <= 55 ; i++) { tickket.sale(); } },"a").start();
        new Thread(() ->{ for (int i = 1; i <= 55 ; i++) { tickket.sale(); } },"b").start();
        new Thread(() ->{ for (int i = 1; i <= 55 ; i++) { tickket.sale(); } },"c").start();
        new Thread(() ->{ for (int i = 1; i <= 55 ; i++) { tickket.sale(); } },"d").start();
        new Thread(() ->{ for (int i = 1; i <= 55 ; i++) { tickket.sale(); } },"e").start();
    }
}
