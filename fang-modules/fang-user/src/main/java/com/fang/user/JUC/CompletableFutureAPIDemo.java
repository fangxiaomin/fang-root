package com.fang.user.JUC;

import java.util.concurrent.*;

/**
 * @author:fxm
 * @createTime:2021/12/23 14:58
 */
public class CompletableFutureAPIDemo {
   public static void main(String[] args) {
        //对计算结果进行合并
        //两个completionStage 任务都完成后，最终把两个任务的结果一起交给thenCombine来处理。先完成的先等着，等待其他任务完成
        System.out.println(CompletableFuture.supplyAsync(() -> {
            return 10;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            return 20;
        }), (r1, r2) -> {
            return r1 + r2;
        }).join());
    }



    public static void m4() {
        //  对计算结果进行筛选。。。谁快用谁
        // 多个线程执行，谁先完成就用谁的返回值。类似于多人跑得快，谁第一个谁赢   applyToEither();

        System.out.println(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        }), r -> {
            return r;
        }).join());


        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
    }


    public static void m3() {
        //对计算结果进行消费,接收任务的处理结果，并消费处理，无返回结果
        CompletableFuture.supplyAsync(() ->{
            return 1;
        }).thenApply(f ->{
            return f+2;
        }).thenApply(f ->{
            return f+3;
        }).thenAccept(r -> System.out.println(r));

        //thenRun 任务A执行完 执行B ，且B不需要A的结果
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenRun(() -> { }).join());
        //  thenAccept 任务A执行完执行B  B 需要A的结果，但是任务B无返回值
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenAccept(resultA -> { }).join());
        // 任务A 执行完任务B B需要A的结果，同时任务B有返回值
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenApply(resultA -> resultA + "  resultB").join());


    }


    public static void m2() {
        //  对计算结果进行处理
        //计算结果存在依赖关系，这两个线程串行化
        //由于存在依赖关系（当前走错，不走下一步），当前步骤有异常的话就叫停   handle---
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        System.out.println(CompletableFuture.supplyAsync(() -> {
            return 1;
        }).handle((f,e) -> {
            System.out.println(" --------------1 ");
            int i =10/0;
            return f + 2;
        }).handle((f,e) -> {
            System.out.println(" --------------2 ");
            return f + 3;
        }).handle((f,e) -> {
            System.out.println(" --------------3 ");
            return f + 4;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("  result :" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        }).join());

        threadPoolExecutor.shutdown();
    }

    public static void m1() {
    //获得结果和触发计算
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        System.out.println(CompletableFuture.supplyAsync(() -> {
            return 1;
        }).thenApply(f -> {
            System.out.println(" --------------1 ");
            return f + 2;
        }).thenApply(f -> {
            System.out.println(" --------------2 ");
            return f + 3;
        }).thenApply(f -> {
            System.out.println(" --------------3 ");
            return f + 4;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("  result :" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        }).join());



        threadPoolExecutor.shutdown();
    }

    public static void m0() throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            return 1;
        });

//        System.out.println(future.get());
//        System.out.println(future.get(3L,TimeUnit.SECONDS));
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
//        System.out.println(future.getNow(9999));
        System.out.println(future.complete(-44) + "\t " + future.get());
        threadPoolExecutor.shutdown();
    }

}
