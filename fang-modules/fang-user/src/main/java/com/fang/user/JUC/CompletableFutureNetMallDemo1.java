package com.fang.user.JUC;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.Getter;
import rx.internal.operators.SingleOnSubscribeDelaySubscriptionOther;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author:fxm
 * @createTime:2021/12/23 10:41
 */
public class CompletableFutureNetMallDemo1 {

    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("pdd"),
            new NetMall("taobao"),
            new NetMall("dangd"),
            new NetMall("tmail")
    );

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
   /* private ExecutorService threadPool = new ThreadPoolExecutor(10, 10,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),
            new ThreadFactoryBuilder().setNameFormat("pool-%d").build(),
            new ThreadPoolExecutor.AbortPolicy());*/

    //同步  step  by  step
    public  List<String> getPriceByStep(List<NetMall> list , String productName){
        return list.stream().map(netMall -> String.format(productName + "in %s price is %.2f", netMall.getMallName(), netMall.calcPrice(productName))).collect(Collectors.toList());
    }

    // 异步
    public  List<String> getPriceBySync(List<NetMall> list , String productName){
        return list.stream().map(netMall -> CompletableFuture.supplyAsync(() -> String.format(productName + "in %s price is %.2f", netMall.getMallName(), netMall.calcPrice(productName)),threadPoolExecutor)).collect(Collectors.toList()).stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        CompletableFutureNetMallDemo1 completableFutureNetMallDemo1 = new CompletableFutureNetMallDemo1();

        long startTime = System.currentTimeMillis();
        List<String> list1 = completableFutureNetMallDemo1.getPriceByStep(list,"mysql");
        for (String s : list1) {
            System.out.println(s);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(" costTime : " + (endTime - startTime) + "毫秒");
        System.out.println();


        long startTime1 = System.currentTimeMillis();
        List<String> list2 = completableFutureNetMallDemo1.getPriceBySync(list,"mysql");
        for (String s : list2) {
            System.out.println(s);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println(" costTime : " + (endTime1 - startTime1) + "毫秒");
        completableFutureNetMallDemo1.threadPoolExecutor.shutdown();
    }
}

class NetMall{
    @Getter
    private String mallName;

    public NetMall(String mallName) {
        this.mallName = mallName;
    }


    //模拟取价格
    public double calcPrice(String productName){
        //检索  1秒钟
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}
