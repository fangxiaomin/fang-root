package com.fang.user.controller;

import com.fang.common.web.Result;
import com.fang.user.entity.AddUserParm;
import com.fang.user.entity.Order;
import com.fang.user.entity.User;
import com.fang.user.service.IOrderService;
import com.fang.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:    http://localhost:7071/doc.html
 * @projectName:fang-root
 * @see:com.fang.user.controller
 * @author:fxm
 * @createTime:2021/6/16 17:05
 * @version:1.0
 */
@RestController
@RequestMapping(value = "user")
@Api(value = "测试接口", tags = "用户管理相关的接口", description = "用户测试接口")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IOrderService orderService;

    @GetMapping("/test")
    @ApiOperation(value = "查询用户", notes = "查询用户")
    public String Test(){
        //todo  通过 feign 调取 order
        return userService.getOrderData();
    }

    @GetMapping("/testException/{id}")
    public String testException(@PathVariable Long id) {
        return userService.getUserException(id);
    }

    @GetMapping("/getWay")
    public String getWay(){
        return "hello,这是userServer的7071 服务";
    }

    @GetMapping("/getByUsername")
    public String getByUsername(){
        return "hello,这是userName=  吴亦凡";
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public String addUser(AddUserParm addUserParm){
        return "成功";
    }


    ////////////////////////////////////////////////////////////

    @GetMapping("/getUserById")
    @ApiOperation(value = "mybatis查询详情", notes = "查询用户111")
    public User getUserById(@RequestParam("id") Integer id){
        //todo  通过 feign 调取 order
        return userService.getUserById(id);
    }

    @GetMapping("/getOrderById")
    @ApiOperation(value = "mybatisPlus查询订单", notes = "查询订单")
    public Order getOrderById(@RequestParam("id") Integer id){
        //todo  通过 feign 调取 order
        return orderService.getOrderById(id);
    }




}
