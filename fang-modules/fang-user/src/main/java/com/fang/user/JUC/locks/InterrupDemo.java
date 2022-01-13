package com.fang.user.JUC.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author:fxm  如何使用中断标识停止线程
 * @createTime:2021/12/28 14:23
 */
public class InterrupDemo {
    static volatile boolean isstop = false ;
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    
    /**
     * @Description:  静态的 interrupted() 方法 
     * 
     **/
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "----" +  Thread.interrupted());
        System.out.println(Thread.currentThread().getName() + "----" +  Thread.interrupted());
        System.out.println("11111111111");
        Thread.currentThread().interrupt();  //  false  --->  true
        System.out.println("2222222");
        System.out.println(Thread.currentThread().getName() + "----" +  Thread.interrupted());
        System.out.println(Thread.currentThread().getName() + "----" +  Thread.interrupted());
    }

    private static void m5() {
        Thread t1 = new Thread(() -> {
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println(" isInterrupted() == true,程序结束。");
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();//线程中断标志位为false,无法停下。需要再次调interrupt()设置为true
                    e.printStackTrace();
                }
                System.out.println("-----hello  interrupt");
            }

        },"t1");
        t1.start();
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(() ->{
            t1.interrupt();//修改t1线程的中断标识位为true
        },"t2").start();
    }

    private static void m4() {
        //中断为true后，并不是立刻stop程序
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 300; i++) {
                System.out.println("----------:" + i);
            }
            System.out.println(" t1.isInterrupted()调用之后02:" + Thread.currentThread().isInterrupted());
        },"t1");
        t1.start();
        System.out.println(" t1.isInterrupted()调用之前,t1线程的中断标识默认值:" + t1.isInterrupted());
        try { TimeUnit.MILLISECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        // 实例方法interrupt() 仅仅是设置线程的中断状态位设置为 true  不会停止线程
        t1.interrupt();
        //活动状态，t1线程还在执行中
        System.out.println(" t1.isInterrupted()调用之后01:" + t1.isInterrupted());
        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        // 非活动状态，t1线程不再执行中，已经结束执行了。
        System.out.println(" t1.isInterrupted()调用之后03:" + t1.isInterrupted());
    }

    /**
     * @Description:  通过Thread 类自带的中断api方法实现
     *
     **/
    private static void m3() {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("------isInterrupted()   is true 程序结束");
                    break;
                }
                System.out.println("------------hello isInterrupted() ");
            }
        }, "t1");
        t1.start();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() ->{
           t1.interrupt();//修改t1线程的中断标识位为true
        },"t2").start();
    }


    /**
     * @Description: 通过   AtomicBoolean
     *
     **/
    private static void m2() {
        new Thread(() ->{
            while (true){
                if(atomicBoolean.get()){
                    System.out.println("------atomicBoolean.get()   is true 程序结束");
                    break;
                }
                System.out.println("------------hello ");
            }
        },"t1").start();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() ->{
            atomicBoolean.set(true);
        },"t2").start();
    }


    /**
     * @Description: 通过一个volatile变量实现
     * 
     **/
    private static void m1() {
        new Thread(() ->{
            while (true){
                if(isstop){
                    System.out.println("------isstop is true 程序结束");
                    break;
                }
                System.out.println("------------hello ");
            }
        },"t1").start();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() ->{
            isstop = true;
        },"t2").start();
    }
}
