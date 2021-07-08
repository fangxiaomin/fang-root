package com.fang.user.feign;

import com.fang.common.web.Result;
import com.fang.order.dto.OrderUserDto;
import com.fang.order.entity.Order;
import com.fang.order.feign.OrderFeginClient;
import com.fang.order.parms.OrderInfoParm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description: fallback: 定义容错的处理类，当调用远程接口失败或超时时，会调用对应接口的容错逻辑，fallback指定的类必须实现@FeignClient标记的接口
 * @projectName:fang-root
 * @see:com.fang.common.feign
 * @author:fxm
 * @createTime:2021/6/23 14:35
 * @version:1.0
 */
@Component
@Slf4j
public class UserOrderFeginFallback implements UserOrderFeignClient {


    @Override
    public OrderUserDto getOrderInfo(OrderInfoParm parm) {
        OrderUserDto orderUserDto = new OrderUserDto();
        log.info("feign调用  出错了  返回 null 服务降级  ");
        return orderUserDto;
    }


    @Override
    public Result getUserException(Long id) {
        log.error("id {},throwable class:{}", id);
        return new Result("feign  服务调用失败", 500);
    }
}
