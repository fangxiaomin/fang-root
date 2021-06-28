package com.fang.common.exception;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 基本异常，系统定义的所有异常都需要继承这个基本类
 * @projectName:fang-root
 * @see:com.fang.common.exception
 * @author:fxm
 * @createTime:2021/6/23 14:11
 * @version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseException extends RuntimeException{
    private static final long serialVersionUID = 7859712770754900356L;

    private Integer code;
    private String msg;

    public BaseException(String message) {
        super(message);
    }
}
