package com.fang.order.service.impl;

import com.fang.order.dto.OrderUserDto;
import com.fang.order.entity.Order;
import com.fang.order.parms.OrderInfoParm;
import com.fang.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.order.service.impl
 * @author:fxm
 * @createTime:2021/6/24 14:00
 * @version:1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {
    @Override
    public OrderUserDto getOrderInfo(OrderInfoParm parm) {
//        log.info("参数：userId {} " + parm.getUserId());
//        log.info("参数：name {}" + parm.getName());
        OrderUserDto orderUserDto = new OrderUserDto(1,"no001", BigDecimal.valueOf(0.111));
        return orderUserDto;
    }

    @Override
    public Order getOrder(Long id) {
        Order order = new Order();
        order.setId(2L);
        order.setPassword("111111");
        order.setUsername("测试Ribbon负载均衡");
        return order;
    }

    @Override
    public List<Order> listUsersByIds(List<Long> ids) {
        List<Order> list = new ArrayList<>();
        Order order = new Order();
        order.setId(3L);
        order.setPassword("3333");
        order.setUsername("测试Hystris合并功能 order ");

        Order order1 = new Order();
        order1.setId(3L);
        order1.setPassword("3333");
        order1.setUsername("测试Hystris合并功能 order 1 ");

        Order order2 = new Order();
        order2.setId(3L);
        order2.setPassword("3333");
        order2.setUsername("测试Hystris合并功能 orde 2 ");
        list.add(order);
        list.add(order1);
        list.add(order2);
        return list;
    }
}
