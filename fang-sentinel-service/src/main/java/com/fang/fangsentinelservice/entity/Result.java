package com.fang.fangsentinelservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.common.web
 * @author:fxm
 * @createTime:2021/6/25 14:29
 * @version:1.0
 */

@Data
@NoArgsConstructor
public class Result<T> implements Serializable {
    private T data;
    private String message;

    private int code;

    public Result(T data, String message, int code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public Result(String message, int code) {
       this(null,message,code);
    }

    public Result(T data) {
        this(data, "操作成功", 200);
    }
}
