package com.fang.user.JUC.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author:fxm
 * @createTime:2021/12/31 15:51
 */

class MyVar{
    public volatile Boolean isInt = Boolean.FALSE;

    AtomicReferenceFieldUpdater<MyVar,Boolean> fieldUpdater = AtomicReferenceFieldUpdater.newUpdater(MyVar.class,Boolean.class,"isInt");

    public void init(MyVar myVar){
        if(fieldUpdater.compareAndSet(myVar,Boolean.FALSE,Boolean.TRUE)){
            System.out.println(Thread.currentThread().getName()+"\t" + "start init ");
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName()+"\t" + "end init ");
        }else {
            System.out.println(Thread.currentThread().getName()+"\t" + "失败失败失败失败失败，已有线程修改中 ");
        }
    }
}

/**
 * @Description:   多线程并发调用一个类的初始化方法，如果未被初始化过，将执行初始化工作，要求只能初始化一次
 * 
 **/
public class AtomicReferenceFieldUpdaterDemo {
    public static void main(String[] args) {
        MyVar myVar = new MyVar();
        for (int i = 1; i <= 5 ; i++) {
            new Thread(() ->{
                myVar.init(myVar);
            },String.valueOf(i)).start();
        }
    }


}
