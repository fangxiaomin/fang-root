package com.fang.user.design.observer;

/**
 * @author:fxm
 * @createTime:2021/9/1 14:55
 */
public class ObserverTest {
    public static void main(String[] args) {
        try {
            ClientDataObserver.send("我是观察者模式");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
