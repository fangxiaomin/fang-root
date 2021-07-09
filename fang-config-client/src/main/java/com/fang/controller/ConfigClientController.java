package com.fang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.controller
 * @author:fxm
 * @createTime:2021/7/8 16:52
 * @version:1.0
 */

//刷新配置
@RefreshScope
@RestController
public class ConfigClientController {

    @Value("${data}")
    private String data;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }

    @RequestMapping("/getData")
    public void getData(){
        System.out.println(data);
    }
}
