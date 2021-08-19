package com.fang.fangsentinelservice.feign;

import com.fang.fangsentinelservice.entity.Result;
import com.fang.fangsentinelservice.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:   服务降级处理
 */
public class NacosFallbackService implements NacosUserService {
    @Override
    public Result insert(User user) {
        return new Result("调用失败，insert服务被降级",500);
    }

    @Override
    public Result<User> getUser(Long id) {
        return new Result("调用失败，getUser服务被降级",500);
    }

    @Override
    public Result<List<User>> listUsersByIds(List<Long> ids) {
        return new Result("调用失败，listUsersByIds服务被降级",500);
    }

    @Override
    public Result<User> getByUsername(String username) {
        return new Result("调用失败，getByUsername服务被降级",500);
    }

    @Override
    public Result update(User user) {
        return new Result("调用失败，update服务被降级",500);
    }

    @Override
    public Result delete(Long id) {
        return new Result("调用失败，delete服务被降级",500);
    }
}
