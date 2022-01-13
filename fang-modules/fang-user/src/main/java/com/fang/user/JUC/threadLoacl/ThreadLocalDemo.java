package com.fang.user.JUC.threadLoacl;

/**
 * @author:fxm
 * @createTime:2022/1/4 16:35
 */
class MovieTicket{
    int number = 50 ;
    public void saleTicket(){
        if(number > 0 ){
            System.out.println(Thread.currentThread().getName()+ " m卖出了 "+ (number--));
        } else {
            System.out.println("..........卖光了。。。");
        }
    }
}
class House{
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0 );
    public void saleHouse(){
        Integer value = threadLocal.get();
        ++value;
        threadLocal.set(value);
    }
}
public class ThreadLocalDemo {
    public static void main(String[] args) {
        /*MovieTicket movieTicket = new MovieTicket();
        for (int i = 1; i <= 3 ; i++) {
            new Thread(() ->{
                for (int j = 1; j <= 20 ; j++) {
                    movieTicket.saleTicket();
                }
            },String.valueOf(i)).start();
        }*/
        House house = new House();
        new Thread(() ->{
            for (int i = 1; i <= 3 ; i++) {
                house.saleHouse();
            }
            System.out.println(Thread.currentThread().getName()+ "卖了" + house.threadLocal.get());
        },"t1").start();

        new Thread(() ->{
            for (int i = 1; i <= 5 ; i++) {
                house.saleHouse();
            }
            System.out.println(Thread.currentThread().getName()+ "卖了" + house.threadLocal.get());
        },"t2").start();

        new Thread(() ->{
            for (int i = 1; i <=10; i++) {
                house.saleHouse();
            }
            System.out.println(Thread.currentThread().getName()+ "卖了" + house.threadLocal.get());
        },"t3").start();

    }
}
