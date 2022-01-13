package com.fang.user.reentrantlock;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * @author:fxm
 * @createTime:2021/10/12 15:15
 */
@RestController
public class ReentranLockController {

    @Autowired
    private ReentranLockService reentranLockService;

    @GetMapping("lock/test")
    public String lockTest(){
        //用 CountDownLatch 来模拟一下并发：
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    countDownLatch.await();
                    reentranLockService.sellProduct();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            countDownLatch.countDown();
        }
         return "success";
    }
}
