package com.fang.hystrix.service;

import com.fang.common.web.Result;
import com.fang.hystrix.entity.Order;

import java.util.concurrent.Future;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.hystrix.service
 * @author:fxm
 * @createTime:2021/6/28 15:33
 * @version:1.0
 */
public interface IHystrixService {

    Result getUser(Long id);

    Result getUserCommand(Long id);

    Result getUserException(Long id);

    Result getUserCache(Long id);

    Result removeCache(Long id);

    @Deprecated
    Future<Order> getUserFuture(Long id);

    Future<String> merge(Integer id);


}
