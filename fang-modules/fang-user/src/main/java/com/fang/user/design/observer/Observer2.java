package com.fang.user.design.observer;

/**
 * @author:fxm
 * @createTime:2021/9/1 13:59
 */
public class Observer2 implements ObserverData{
    @Override
    public void processData(String message) throws Exception {
        System.out.println("Observer2......."+message);
    }
}
