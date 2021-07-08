package com.fang.order.controller.feign;

import com.fang.common.web.Result;
import com.fang.order.dto.OrderUserDto;
import com.fang.order.entity.Order;
import com.fang.order.parms.OrderInfoParm;
import com.fang.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/userOrderFeign")
public class OrderFeignController {

    @Autowired
    IOrderService orderService;

    @PostMapping("/order/getOrderInfo")
    public OrderUserDto getOrderInfo(@RequestBody OrderInfoParm parm){
        log.info("Feign  调用 进来了。。。" + parm.getName());
        return orderService.getOrderInfo(parm);
    }

    @PostMapping("/order/getException")
    public Result<Order> getUser(@RequestParam(value = "id") Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }
        Order user = orderService.getOrder(id);
        log.info("根据id获取用户信息，用户名称为：{}",user.getUsername());
        return new Result<Order>(user);
    }

}
