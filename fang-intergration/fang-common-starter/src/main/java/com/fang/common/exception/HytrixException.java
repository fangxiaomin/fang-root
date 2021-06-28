package com.fang.common.exception;

import com.netflix.hystrix.exception.HystrixBadRequestException;

/**
 * @description:避免熔断异常处理
 * @projectName:fang-root
 * @see:com.fang.common.exception
 * @author:fxm
 * @createTime:2021/6/23 14:10
 * @version:1.0
 */
public class HytrixException extends HystrixBadRequestException {
    private static final long serialVersionUID = -2437160791033393978L;

    public HytrixException(String msg) {
        super(msg);
    }

    public HytrixException(Exception e){
        this(e.getMessage());
    }
}
