package com.fang.fangsentinelservice.feign;

import com.fang.common.web.Result;
import com.fang.fangsentinelservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:   测试 Sentinel也适配了Feign组件  然后测试 ===》 熔断
 */
@FeignClient(value = "fang-nacos", fallback = NacosFallbackService.class)
public interface NacosUserService {

    @PostMapping("/nacos/insert")
    Result insert(@RequestBody User user);

    @GetMapping("/nacos/{id}")
    Result<User> getUser(@PathVariable Long id);

    @GetMapping("/nacos/listUsersByIds")
    Result<List<User>> listUsersByIds(@RequestParam List<Long> ids);

    @GetMapping("/nacos/getByUsername")
    Result<User> getByUsername(@RequestParam String username);

    @PostMapping("/nacos/update")
    Result update(@RequestBody User user);

    @PostMapping("/nacos/delete/{id}")
    Result delete(@PathVariable Long id);
}
