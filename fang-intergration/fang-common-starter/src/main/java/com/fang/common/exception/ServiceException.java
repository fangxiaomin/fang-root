package com.fang.common.exception;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.common.exception
 * @author:fxm
 * @createTime:2021/6/23 14:11
 * @version:1.0
 */
public class ServiceException extends BaseException{

    public ServiceException(Exception e ) {
        this(e.getMessage());
    }

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(Integer code, String msg) {
        super(code, msg);
    }
}
