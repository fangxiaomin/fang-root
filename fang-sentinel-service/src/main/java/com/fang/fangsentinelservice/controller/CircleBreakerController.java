package com.fang.fangsentinelservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.fang.fangsentinelservice.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 */

@Slf4j
@RestController
@RequestMapping("/breaker")
public class CircleBreakerController {

    @Autowired
    private RestTemplate restTemplate;
    private static String userServiceUrl ="http://fang-order";

    @GetMapping("/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handleFallback")
    public Result fallback(@PathVariable Long id) {
        Result forObject = restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
        System.out.println(forObject);
        return forObject;
    }

    //exceptionsToIgnore参数忽略了NullPointerException，
    @GetMapping("/fallbackException/{id}")
    @SentinelResource(value = "fallbackException", fallback = "handleFallback2", exceptionsToIgnore = {NullPointerException.class})
    public Result fallbackException(@PathVariable Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }

        return restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
    }

    public Result handleFallback(Long id) {
        return new Result("服务降级返回", 200);
    }

    public Result handleFallback2(Long id, Throwable e) {
        log.error("handleFallback2 id:{},throwable class:{}", id, e.getClass());
        return new Result("服务降级返回", 200);
    }
}
