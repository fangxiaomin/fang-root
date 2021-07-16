package com.fang.user.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.controller
 * @author:fxm
 * @createTime:2021/7/16 14:07
 * @version:1.0
 */
@RefreshScope
@RestController
public class ConfigClientController {

  /*  @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }*/
}
