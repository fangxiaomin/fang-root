package com.fang.fangnacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.fangnacos.controller
 * @author:fxm
 * @createTime:2021/8/13 14:45
 * @version:1.0
 */
@RefreshScope
@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public Object getConfigInfo() {
        return configInfo;
    }
}
