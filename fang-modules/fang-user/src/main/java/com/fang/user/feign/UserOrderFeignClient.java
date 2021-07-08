package com.fang.user.feign;

import com.fang.common.feign.FeignExceptionConfig;
import com.fang.common.web.Result;
import com.fang.order.dto.OrderUserDto;
import com.fang.order.entity.Order;
import com.fang.order.feign.OrderFeginFallback;
import com.fang.order.parms.OrderInfoParm;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.feign
 * @author:fxm
 * @createTime:2021/7/1 17:07
 * @version:1.0
 */
@FeignClient(value = "fang-order",contextId = "orderUser",path = "/userOrderFeign",configuration  = FeignExceptionConfig.class,fallback = UserOrderFeginFallback.class)
public interface UserOrderFeignClient {

    @PostMapping("/order/getOrderInfo")
    OrderUserDto getOrderInfo(@RequestBody OrderInfoParm parm);

    @PostMapping("/order/getException")
    Result<Order> getUserException(@RequestParam(value = "id") Long id);

}
