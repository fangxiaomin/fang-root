package com.fang.order.feign;

import com.fang.common.feign.FeignExceptionConfig;
import com.fang.order.dto.OrderUserDto;
import com.fang.order.parms.OrderInfoParm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @description: configuration: Feign配置类，可以自定义Feign的Encoder、Decoder、LogLevel、Contract
 * @projectName:fang-root
 * @see:com.fang.order.feign 测试一下
 * @author:fxm
 * @createTime:2021/6/16 17:24
 * @version:1.0
 */
@FeignClient(value = "fang-order",contextId = "orderUser",path = "/orderFeign",configuration  = FeignExceptionConfig.class,fallback = OrderFeginFallback.class)
public interface OrderFeginClient {

    @PostMapping("/order/getOrderInfo")
    OrderUserDto getOrderInfo(@RequestBody OrderInfoParm parm);
}
