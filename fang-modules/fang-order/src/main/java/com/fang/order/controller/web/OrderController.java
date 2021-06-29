package com.fang.order.controller.web;

import com.fang.common.web.Result;
import com.fang.order.entity.Order;
import com.fang.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/listUsersByIds")
    public Result<List<Order>> listUsersByIds(@RequestParam List<Long> ids) {
        List<Order> userList= orderService.listUsersByIds(ids);
        log.info("根据ids获取用户信息，用户列表为：{}",userList);
        return new Result<List<Order>>(userList);
    }

    @RequestMapping("/merge")
    public List<String> demo(String id){
        System.out.println("合并之后的请求参数："+id);
        System.out.println("这里应该拿到单个的请求参数，分别去数据库中查询，为了方便我就用集合模拟了请求结果");
        List<String> list = new ArrayList<>();
        list.add("模拟请求结果：result1");
        list.add("模拟请求结果：result2");
        list.add("模拟请求结果：result3");
        return list;
    }
}
