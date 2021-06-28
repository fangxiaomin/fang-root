package com.fang.user.controller;

import com.fang.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.controller
 * @author:fxm
 * @createTime:2021/6/16 17:05
 * @version:1.0
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/test")
    public String Test(){
        //todo  通过 feign 调取 order
        return userService.getOrderData();
    }
}
