package com.fang.fangnacos.controller;

import com.fang.common.web.Result;
import com.fang.fangnacos.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.fangnacos.controller
 * @author:fxm
 * @createTime:2021/8/17 16:06
 * @version:1.0
 */
@Slf4j
@RestController
@RequestMapping("/nacos")
public class UserFeignController {

    @PostMapping("/insert")
    public Result insert(@RequestBody User user) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功");
        result.setData(user);
        return result;
    }

    @GetMapping("/{id}")
    public Result<User> getUser(@PathVariable Long id) throws Exception {
        if(id == 4 ){
            throw new Exception();
        }
        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功");
        User user = new User();
        user.setUsername("1111111111");
        result.setData(user);
        log.info("根据id获取用户信息，用户名称为：{}",user.getUsername());
        return result;
    }

    @GetMapping("/listUsersByIds")
    public Result<List<User>> listUsersByIds(@RequestParam List<Long> ids) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功");
        User user = new User();
        user.setUsername("1111111111");
        User user1 = new User();
        user1.setUsername("2222");

        List<User> list=new ArrayList<User>();
        list.add(user1);
        list.add(user);
        result.setData(list);
        log.info("根据id批量获取用户信息，用户名称为：{}",user.getUsername());
        return result;
    }

    @GetMapping("/getByUsername")
    public Result<User> getByUsername(@RequestParam String username) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功");
        User user = new User();
        user.setUsername(username);
        result.setData(user);
        log.info("根据username获取用户信息，用户名称为：{}",user.getUsername());
        return result;
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功");
        result.setData(user);
        log.info("修改用户信息，用户名称为：{}",user.getUsername());
        return result;
    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功");
        result.setData(id);
        log.info("删除，用户名称为：{}",id);
        return result;
    }
}
