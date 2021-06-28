package com.fang.order.controller.web;

import com.fang.common.web.Result;
import com.fang.order.entity.Order;
import com.fang.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.order.controller.web
 * @author:fxm
 * @createTime:2021/6/25 14:35
 * @version:1.0
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @GetMapping("/{id}")
    public Result<Order> getUser(@PathVariable Long id) {
        Order user = orderService.getOrder(id);
        log.info("根据id获取用户信息，用户名称为：{}",user.getUsername());
        return new Result<Order>(user);
    }
}
