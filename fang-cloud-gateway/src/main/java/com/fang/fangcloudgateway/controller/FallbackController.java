package com.fang.fangcloudgateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.fangcloudgateway.controller
 * @author:fxm
 * @createTime:2021/7/21 16:59
 * @version:1.0
 */
@Api(tags = "测试swagger")
@RestController
public class FallbackController {

    @GetMapping("/fallback")
    @ApiOperation("swagger接口")
    public Object fallback() {
        Map<String,Object> result = new HashMap<>();
        result.put("data",null);
        result.put("message","Get request fallback  服务暂时不可用 !");
        result.put("code",500);
        return result;
    }
}
