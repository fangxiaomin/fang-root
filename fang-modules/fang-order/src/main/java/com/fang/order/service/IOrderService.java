package com.fang.order.service;

import com.fang.order.dto.OrderUserDto;
import com.fang.order.entity.Order;
import com.fang.order.parms.OrderInfoParm;

import java.util.List;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.order.service
 * @author:fxm
 * @createTime:2021/6/24 13:58
 * @version:1.0
 */
public interface IOrderService {

    OrderUserDto getOrderInfo(OrderInfoParm parm);
    Order getOrder(Long id);
    List<Order> listUsersByIds(List<Long> ids);
}
