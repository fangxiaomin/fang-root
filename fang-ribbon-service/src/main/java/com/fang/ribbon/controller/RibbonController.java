package com.fang.ribbon.controller;

import com.fang.common.web.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.ribbon.controller
 * @author:fxm
 * @createTime:2021/6/25 14:53
 * @version:1.0
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @GetMapping("/{id}")
    public Result getUser(@PathVariable Long id) {
        return restTemplate.getForObject(userServiceUrl + "/order/{1}", Result.class, id);
    }

}
