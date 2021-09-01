package com.fang.user.design.observer;

/**
 * @author:fxm
 * @createTime:2021/9/1 14:00
 */
public class Observer3 implements ObserverData{
    @Override
    public void processData(String message) throws Exception {
        //处理自己的逻辑
        System.out.println("Observer3......."+message);

    }
}
