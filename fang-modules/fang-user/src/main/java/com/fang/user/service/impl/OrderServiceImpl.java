package com.fang.user.service.impl;

import com.fang.user.entity.Order;
import com.fang.user.mapper.IOrderMapper;
import com.fang.user.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.service.impl
 * @author:fxm
 * @createTime:2021/8/23 17:19
 * @version:1.0
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private IOrderMapper orderMapper;

    @Override
    public Order getOrderById(Integer id) {
        Order order = orderMapper.selectById(id);
        return order;
    }

    public static void main(String[] args) {
        StringJoiner sj =new StringJoiner(",");
        IntStream.range(1,10).forEach(i->sj.add(i+""));
        sj.add("5555");
        StringJoiner other = new StringJoiner(".");
        other.add("3333333");
        sj.merge(other);
        sj.setEmptyValue("22222222222222");
        System.out.println(sj.toString());
    }
}
