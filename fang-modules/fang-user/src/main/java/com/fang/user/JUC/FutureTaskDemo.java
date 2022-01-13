package com.fang.user.JUC;

import org.springframework.retry.backoff.ThreadWaitSleeper;

import java.lang.annotation.ElementType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author:fxm     FutureTask  异步执行   主线程不受影响，子线程去执行任务并返回数据
 * @createTime:2021/12/22 15:00
 */
class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + " \t " + " ...  come in ");
            try {
                //  futureTast  花 2 秒执行任务
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1024;

        });

        new Thread(futureTask,"t1").start();

//        System.out.println(futureTask.get(2L,TimeUnit.SECONDS));  //过时不候

        //不要阻塞，尽量轮询替代
        while (true) {
            if(futureTask.isDone()){
                System.out.println( " ---------result " + futureTask.get());
                break;
            }else {
                System.out.println(" 还在继续计算中。。。。");
            } }
        System.out.println(" ----  主线程继续干事情");

//        System.out.println(futureTask.get());  //只要出现get 不管是否计算完成都阻塞等待结果出来在运行

    }
}
