package com.fang.user.service;

import com.fang.user.entity.Order;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.service
 * @author:fxm
 * @createTime:2021/8/23 17:18
 * @version:1.0
 */
public interface IOrderService {
    Order getOrderById(Integer id);
}
