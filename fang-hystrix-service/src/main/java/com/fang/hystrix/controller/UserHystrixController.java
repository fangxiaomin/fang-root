package com.fang.hystrix.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.fang.common.web.Result;
import com.fang.hystrix.entity.Order;
import com.fang.hystrix.service.IHystrixService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.hystrix.controller
 * @author:fxm
 * @createTime:2021/6/28 15:32
 * @version:1.0
 */
@RestController
@RequestMapping("/hystrix")
public class UserHystrixController {

    @Autowired
    private IHystrixService hystrixService;

    @GetMapping("/testFallback/{id}")
    public Result testFallback(@PathVariable Long id) {
        return hystrixService.getUser(id);
    }

    /**
     * @Description: 设置命令、分组及线程池名称
     * author: fxm
     * createTime: 2021/6/28 16:23
     **/
    @GetMapping("/testCommand/{id}")
    public Result getUserCommand(@PathVariable Long id) {
        return hystrixService.getUserCommand(id);
    }

    /**
     * @Description:使用ignoreExceptions忽略某些异常降级 
     * author: fxm
     * createTime: 2021/6/28 16:47
     **/
    @GetMapping("/testException/{id}")
    public Result testException(@PathVariable Long id) {
        return hystrixService.getUserException(id);
    }

    /**  添加缓存  使用缓存
     * @Description:
     * author: fxm
     * createTime: 2021/6/28 17:41
     **/
    @GetMapping("/testCache/{id}")
    public Result testCache(@PathVariable Long id) {
        hystrixService.getUserCache(id);
        hystrixService.getUserCache(id);
        hystrixService.getUserCache(id);
        return new Result("操作成功", 200);
    }

    /**
     * @Description:  移除缓存
     * author: fxm
     * createTime: 2021/6/28 17:41
     **/
    @GetMapping("/testRemoveCache/{id}")
    public Result testRemoveCache(@PathVariable Long id) {
        hystrixService.getUserCache(id);
        hystrixService.removeCache(id);
        hystrixService.getUserCache(id);
        return new Result("操作成功", 200);
    }


    @Deprecated
    @GetMapping("/testCollapser")
    public Result testCollapser() throws ExecutionException, InterruptedException {
        Future<Order> future1 = hystrixService.getUserFuture(1L);
        Future<Order> future2 = hystrixService.getUserFuture(2L);
        future1.get();
        future2.get();
        ThreadUtil.safeSleep(100);
        Future<Order> future3 = hystrixService.getUserFuture(3L);
        future3.get();
        return new Result("操作成功", 200);
    }

    /**
     * @Description: 注解的方式进行请求合并    Hystrix  的合并请求
     * author: fxm
     * createTime: 2021/6/29 16:33
     **/
    @RequestMapping("/merge2")
    public void merge3() throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        Future<String> future1 = hystrixService.merge(1);
        Future<String> future2 = hystrixService.merge(2);
        Future<String> future3 = hystrixService.merge(3);

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
    }







}
