package com.fang.user.design.observer;

/**
 * @desc: 观察者基类
 * @author:fxm
 * @createTime:2021/9/1 13:58
 */
public interface ObserverData {
    void processData(String message) throws Exception;
}
