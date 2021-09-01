package com.fang.user.design.observer;

/**
 *              观察者实现类
 * @author:fxm
 * @createTime:2021/9/1 13:59
 */
public class Observer1 implements ObserverData{
    @Override
    public void processData(String message) throws Exception {
        System.out.println("Observer1.......{}"+message);
    }
}
