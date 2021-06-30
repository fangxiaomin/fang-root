package com.fang.hystrix.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.fang.common.web.Result;
import com.fang.hystrix.entity.Order;
import com.fang.hystrix.service.IHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.Future;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.hystrix.service.impl
 * @author:fxm
 * @createTime:2021/6/28 15:34
 * @version:1.0
 */
@Slf4j
@Service
public class HystrixServiceImpl implements IHystrixService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @HystrixCommand(fallbackMethod = "fallbackMethod1")
    @Override
    public Result getUser(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/order/{1}", Result.class, id);
    }


    /**
     * 声明的参数需要包含controller的声明参数
     *
     * @param id
     * @return
     */
    public Result fallbackMethod1(@PathVariable Long id) {
        return new Result("服务调用失败", 500);
    }


    @Override
    @HystrixCommand(fallbackMethod = "fallbackMethod1",
            commandKey = "getUserCommand",
            groupKey = "getUserGroup",
            threadPoolKey = "getUserThreadPool")
    public Result getUserCommand(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/order/{1}", Result.class, id);
    }


    /**
     * @Description: fallbackMethod：指定服务降级处理方法；
     * ignoreExceptions：忽略某些异常，不发生服务降级；
     * commandKey：命令名称，用于区分不同的命令；
     * groupKey：分组名称，Hystrix会根据不同的分组来统计命令的告警及仪表盘信息；
     * threadPoolKey：线程池名称，用于划分线程池。
     * author: fxm
     * createTime: 2021/6/28 16:58
     **/

    @Override
    @HystrixCommand(fallbackMethod = "fallbackMethod2", ignoreExceptions = {NullPointerException.class})
    public Result getUserException(Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }
        return restTemplate.getForObject(userServiceUrl + "/order/{1}", Result.class, id);
    }

    public Result fallbackMethod2(@PathVariable Long id, Throwable e) {
        log.error("id {},throwable class:{}", id, e.getClass());
        return new Result("服务调用失败", 500);
    }


    /**
     * @Description: @CacheResult：开启缓存，默认所有参数作为缓存的key，cacheKeyMethod可以通过返回String类型的方法指定key；
     * @CacheKey：指定缓存的key，可以指定参数或指定参数中的属性值为缓存key，cacheKeyMethod还可以通过返回String类型的方法指定；
     * @CacheRemove：移除缓存，需要指定commandKey。 author: fxm
     * createTime: 2021/6/28 17:01
     **/
    @Override
    @CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand(fallbackMethod = "fallbackMethod1", commandKey = "getUserCache")
    public Result getUserCache(Long id) {
        log.info("走的不是缓存 == 》 getUserCache id:{}", id);
        return restTemplate.getForObject(userServiceUrl + "/order/{1}", Result.class, id);
    }

    /**
     * 为缓存生成key的方法
     *
     * @return
     */
    public String getCacheKey(Long id) {
        return String.valueOf(id);
    }


    /**
     * @Description: 移除缓存
     * author: fxm
     * createTime: 2021/6/28 17:42
     **/
    @Override
    @HystrixCommand
    @CacheRemove(commandKey = "getUserCache", cacheKeyMethod = "getCacheKey")
    public Result removeCache(Long id) {
        log.info("removeCache id:{}", id);
        return restTemplate.getForObject(userServiceUrl + "/order/{1}", Result.class, id);
    }


    //请求合并       batchMethod：用于设置请求合并的方法；
    //              collapserProperties：请求合并属性，用于控制实例属性，有很多；
    //              timerDelayInMilliseconds：collapserProperties中的属性，用于控制每隔多少时间合并一次请求；
    //    @HystrixCollapser的常用属性

    @Override
    @HystrixCollapser(batchMethod = "listUsersByIds", collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "100")
    })
    public Future<Order> getUserFuture(Long id) {
        return new AsyncResult<Order>() {
            @Override
            public Order invoke() {
                Result result = restTemplate.getForObject(userServiceUrl + "/order/{1}", Result.class, id);
                Map data = (Map) result.getData();
                Order user = BeanUtil.mapToBean(data, Order.class, true);
                log.info("getUserById username:{}", user.getUsername());
                return user;
            }
        };
    }

    @HystrixCommand
    public List<Order> listUsersByIds(List<Long> ids) {
        log.info("listUsersByIds:{}", ids);
        Result result = restTemplate.getForObject(userServiceUrl + "/order/listUsersByIds?ids={3}", Result.class, CollUtil.join(ids, ","));
        log.info("返回值。。。。。。。。。。" + JSONUtil.toJsonStr(result));
        List<Order> data = (List<Order>) result.getData();
        return (List<Order>) result.getData();
    }

    //------------------------------
    //指定批处理的方法，设置合并200ms之内的请求
    @Override
    @HystrixCollapser(batchMethod = "getMerge", collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "200")})
    public Future<String> merge(Integer id) {
        //不会进入这个方法体
        return null;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public List<String> getMerge(List<Integer> ids) {
        System.out.println("合并的请求：" + ids.toString());
        String[] result = restTemplate.getForEntity("http://fang-order/order/merge?id={1}", String[].class, StringUtils.join(ids, ",")).getBody();
        System.out.println("合并后的结果" + result);
        return Arrays.asList(result);
    }

    /**
     * 降级方法的参数，返回值类型，返回值数量要和上面的方法对应
     *
     * @param ids
     * @return
     */
    public List<String> fallback(List<Integer> ids) {
        List<String> list = new ArrayList<>();
        list.add("请求合并失败-1");
        list.add("请求合并失败-2");
        list.add("请求合并失败-3");
        return list;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //同步请求
    @HystrixCommand(fallbackMethod = "fallbackMethod1")
    public String execute() {
        String serServiceUrl = userServiceUrl;
        return restTemplate.getForEntity(serServiceUrl + "/order/{1}", String.class).getBody();
    }

    //异步   异步请求的时候同时要实现get方法，否则会报这个错，点进get源码看一下就知道了
    @HystrixCommand(fallbackMethod = "fallbackMethod1")
    public Future<String> queue() {
        String serServiceUrl = userServiceUrl;
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForEntity(serServiceUrl + "/order/{1}", String.class).getBody();
            }

            @Override
            public String get() throws UnsupportedOperationException {
                return invoke();
            }
        };
    }


}
