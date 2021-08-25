package com.fang;

import cn.hutool.json.JSONUtil;
import com.fang.user.entity.Order;
import com.fang.user.service.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @projectName:fang-root
 * @see:PACKAGE_NAME
 * @author:fxm
 * @createTime:2021/8/25 15:12
 * @version:1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    private IOrderService orderService;

    @Test
    public void getOrderById(){
        Order order = orderService.getOrderById(10);
        System.out.println(JSONUtil.toJsonStr(order));

    }
}
