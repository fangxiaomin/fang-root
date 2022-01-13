package com.fang.user.JUC.volatiles;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author:fxm  静态内部类  单例模式
 * @createTime:2021/12/30 15:09
 */
public class SingletonDemo {

    private SingletonDemo(){};

    private static class SingletonDemoHander{
        private static SingletonDemo instance = new SingletonDemo();
    }

    public static SingletonDemo getInstance(){
        return SingletonDemoHander.instance;
    }
}
