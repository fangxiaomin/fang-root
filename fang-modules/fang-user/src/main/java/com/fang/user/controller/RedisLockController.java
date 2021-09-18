package com.fang.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.redisson.api.RedissonClient;
import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author:fxm
 * @createTime:2021/9/16 15:57
 */
@RestController
@Slf4j
public class RedisLockController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redisson;

    private static String EXPRESS_COMPANY = "express:company";

    @PostConstruct
    public void initCompany() {
        stringRedisTemplate.opsForHash().put(EXPRESS_COMPANY, "shunfeng", "顺丰");
        redisTemplate.opsForValue().set("phone", String.valueOf(100));
    }

    @GetMapping(value = "buy")
    public String get() {
        int i = 0;
        //分布式锁，如果为空就set值，并返回1  。。。如果存在(不为空)不进行操作，并返回0
        Boolean phoneLock = redisTemplate.opsForValue().setIfAbsent("phoneLock", "",3, TimeUnit.SECONDS);
        if (!phoneLock) {
            return "";
        }
        try {
                String phone = redisTemplate.opsForValue().get("phone");
                Object express = stringRedisTemplate.opsForHash().get(EXPRESS_COMPANY, "shunfeng");
                Map<Object, Object> map = stringRedisTemplate.opsForHash().entries(EXPRESS_COMPANY);
                Integer cnt = Integer.valueOf(phone);
                if (cnt > 0) {
                    i = cnt;
                    try {
//                        Thread.sleep(1000000L);
                    } catch (Exception e) {

                    }
                    redisTemplate.opsForValue().set("phone", String.valueOf(cnt - 1));
                    System.out.println("抢到了" + cnt + "号商品");
                }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {

            //释放锁
            redisTemplate.delete("phoneLock");
        }
        return "成功";
    }

    @GetMapping(value = "buytimer")
    public String gettimer() {
        int i = 0;
        //分布式锁，如果为空就set值，并返回1  。。。如果存在(不为空)不进行操作，并返回0
        Boolean phoneLock = redisTemplate.opsForValue().setIfAbsent("phoneLock", "",3, TimeUnit.SECONDS);
        if (!phoneLock) {
            return "";
        }
        Timer timer = null;
        try {
            String phone = redisTemplate.opsForValue().get("phone");
            Integer cnt = Integer.valueOf(phone);
            if (cnt > 0) {

                //续命，当执行时间大于 锁的过期时间，就进行不断地续命
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    //创建一个线程不停的给key续命。
                    @Override
                    public void run() {
                        redisTemplate.opsForValue().set("phoneLock", "", 3, TimeUnit.SECONDS);
                    }
                },0,1);

                redisTemplate.opsForValue().set("phone", String.valueOf(cnt - 1));
                System.out.println("抢到了" + cnt + "号商品");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            if (timer != null) {
                timer.cancel();
            }
            //释放锁
            redisTemplate.delete("phoneLock");
        }
        return "成功";
    }

    //使用Redisson 自动续命  框架自带
    @GetMapping(value = "getRedisson")
    public String getRedisson() throws InterruptedException {
        RLock phoneLock = redisson.getLock("phoneLock");  // 拿锁失败时会不停的重试
        // 具有Watch Dog 自动延期机制 默认续30s 每隔30/3=10 秒续到30s
        phoneLock.lock();    // 尝试拿锁10s后停止重试,返回false

        // 具有Watch Dog 自动延期机制 默认续30s
        boolean res1 = phoneLock.tryLock(10, TimeUnit.SECONDS);    // 拿锁失败时会不停的重试
        // 没有Watch Dog ，10s后自动释放
        phoneLock.lock(10,TimeUnit.SECONDS); // 尝试拿锁100s后停止重试,返回false
        // 没有Watch Dog ，10s后自动释放
        boolean res2 = phoneLock.tryLock(100, 10, TimeUnit.SECONDS);    //2. 公平锁 保证 Redisson 客户端线程将以其请求的顺序获得锁

        RLock fairLock = redisson.getFairLock("fairLock");    //3. 读写锁 没错与JDK中ReentrantLock的读写锁效果一样

        System.out.println("当前有线程已经获得了锁锁情况："+phoneLock.isLocked());
        System.out.println(Thread.currentThread().getName()+"获取锁成功");
        Thread.sleep(5000);
//        phoneLock.lock(30, TimeUnit.SECONDS);
        try {
            String phone = redisTemplate.opsForValue().get("phone");
            Integer count = Integer.valueOf(phone);
            if (count > 0) {
                redisTemplate.opsForValue().set("phone", String.valueOf(count - 1));
                System.out.println("抢到了" + count + "号商品");
            }
        } finally {
            System.out.println("当前有线程已经获得了锁锁情况："+phoneLock.isLocked());
            System.out.println("当前有线程已经获得了锁锁情况："+phoneLock.isHeldByCurrentThread());
            if (phoneLock.isLocked() && phoneLock.isHeldByCurrentThread()) {
                phoneLock.unlock();
            }
        }
        return "成功";
    }
}
