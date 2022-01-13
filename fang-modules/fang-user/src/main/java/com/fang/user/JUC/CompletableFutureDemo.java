package com.fang.user.JUC;

import io.swagger.models.auth.In;

import java.util.concurrent.*;

/**
 * @author:fxm
 * @createTime:2021/12/22 16:17
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            //  futureTast  花 2 秒执行任务
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + " ---------- come  in  ");
            return 11;
        }).thenApply(f->{
            return f+2;
        }).whenComplete((v,e) -> {
            if( e == null ){
                System.out.println(" ---- ----result :" + v);
            }
        }).exceptionally(e ->{
            e.printStackTrace();
            return null;
        });
        //主线程不要l立刻结束，否则  CompletableFuture 默认使用的线程池会立刻关闭，暂停3秒钟线程
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("......main over ");

        threadPoolExecutor.shutdown();

    }

    public static void m1() throws ExecutionException, InterruptedException{
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " ---------- come  in  ");
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " ---------- come  in  ");

        }, threadPoolExecutor);

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " ---------- come  in  ");
            return 11;
        });

        System.out.println(future3.get());


        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " ---------- come  in  ");
            return 22;
        },threadPoolExecutor);
        System.out.println(future4.get());

        threadPoolExecutor.shutdown();
    }
}
