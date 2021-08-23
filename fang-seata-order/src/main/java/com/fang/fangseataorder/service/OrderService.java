package com.fang.fangseataorder.service;


import com.fang.fangseataorder.domain.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
