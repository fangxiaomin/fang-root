package com.fang.user.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.fang.common.web.Result;
import com.fang.order.dto.OrderUserDto;
import com.fang.order.entity.Order;
import com.fang.order.parms.OrderInfoParm;
import com.fang.user.entity.User;
import com.fang.user.feign.UserOrderFeignClient;
import com.fang.user.mapper.IOrderMapper;
import com.fang.user.mapper.IUserMapper;
import com.fang.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.service.impl
 * @author:fxm
 * @createTime:2021/6/16 17:13
 * @version:1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Resource
    private UserOrderFeignClient orderFeginClient;

    @Resource
    private IUserMapper userMapper;

    @Override
    public String getOrderData() {
        OrderInfoParm parm =new OrderInfoParm();
        parm.setUserId(1L);
        parm.setName("测试Feign的调用");
        OrderUserDto orderUserDto = orderFeginClient.getOrderInfo(parm);
        if(ObjectUtil.isNull(orderUserDto)){
           return "feign调用出错";
        }
        log.info("返回结果集为： {} " + JSONUtil.toJsonStr(orderUserDto));
        return orderUserDto.getSn();
    }

    @Override
    public String getUserException(Long id) {
//        Result<Order>  result = orderFeginClient.getUserException(id);
//        log.info("返回结果集为： {} " + JSONUtil.toJsonStr(result));
//        Order order = result.getData();
//        String userName = order.getUsername();
        String userName = "juint Test 2021-08-25";
        return userName;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }


}
