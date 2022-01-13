package com.fang.user.JUC;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author:fxm   get   和  join   的区别
 * @createTime:2021/12/23 10:01
 */
public class CompletableFutureNetMallDemo {

    public static void main(String[] args)  {
        System.out.println(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println(" ------ result " + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        }).join());
        System.out.println( "---------- main  is over " );

        //暂停几秒钟   主线程不要l立刻结束，否则  CompletableFuture 默认使用的线程池会立刻关闭，暂停3秒钟线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
    }

}
