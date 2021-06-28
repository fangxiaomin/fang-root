package com.fang.order.controller.feign;

import com.fang.order.dto.OrderUserDto;
import com.fang.order.parms.OrderInfoParm;
import com.fang.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.order.controller.feign
 * @author:fxm
 * @createTime:2021/6/24 13:52
 * @version:1.0
 */
@Slf4j
@RestController
@RequestMapping("/orderFeign")
public class OrderFeignController {

    @Autowired
    IOrderService orderService;

    @PostMapping("/order/getOrderInfo")
    public OrderUserDto getOrderInfo(@RequestBody OrderInfoParm parm){
        log.info("Feign  调用 进来了。。。" + parm.getName());
        return orderService.getOrderInfo(parm);
    }
}
