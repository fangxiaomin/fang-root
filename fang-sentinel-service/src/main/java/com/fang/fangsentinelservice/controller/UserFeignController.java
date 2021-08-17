package com.fang.fangsentinelservice.controller;

import com.fang.common.web.Result;
import com.fang.fangsentinelservice.entity.User;
import com.fang.fangsentinelservice.feign.NacosUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 */
@RestController
@RequestMapping("/nacos")
public class UserFeignController {

    @Autowired
    private NacosUserService nacosUserService;

    @PostMapping("/insert")
    public Result insert(@RequestBody User user) {
        return nacosUserService.insert(user);
    }

    @GetMapping("/{id}")
    public Result<User> getUser(@PathVariable Long id) {
        return nacosUserService.getUser(id);
    }

    @GetMapping("/listUsersByIds")
    public Result<List<User>> listUsersByIds(@RequestParam List<Long> ids) {
        return nacosUserService.listUsersByIds(ids);
    }

    @GetMapping("/getByUsername")
    public Result<User> getByUsername(@RequestParam String username) {
        return nacosUserService.getByUsername(username);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return nacosUserService.update(user);
    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        return nacosUserService.delete(id);
    }

}

