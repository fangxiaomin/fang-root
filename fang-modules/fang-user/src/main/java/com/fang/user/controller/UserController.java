package com.fang.user.controller;

import com.fang.common.web.Result;
import com.fang.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/testException/{id}")
    public String testException(@PathVariable Long id) {
        return userService.getUserException(id);
    }

    @RequestMapping("/getWay")
    public String getWay(){
        return "hello,这是userServer的7071 服务";
    }

    @RequestMapping("/getByUsername")
    public String getByUsername(){
        return "hello,这是userName=  吴亦凡";
    }



}
