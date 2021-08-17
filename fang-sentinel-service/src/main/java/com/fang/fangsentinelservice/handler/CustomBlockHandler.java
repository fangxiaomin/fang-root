package com.fang.fangsentinelservice.handler;


import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fang.common.web.Result;

public class CustomBlockHandler {

    public Result handleException(BlockException exception) {
        return new Result("自定义限流信息", 200);
    }
}
