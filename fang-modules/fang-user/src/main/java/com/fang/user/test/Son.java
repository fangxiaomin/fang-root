package com.fang.user.test;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.test
 * @author:fxm
 * @createTime:2021/8/30 18:03
 * @version:1.0
 */
public class Son extends Father {
    private String name;
    static {
        System.out.println("子类的静态代码块");
    }
    {
        //构造代码块
        System.out.println("子类的构造代码块");
    }

    public Son(){
        this("小三");//在执行子类的含参构造方法 但是没有对象产生
        System.out.println("子类无参构造方法");
        //普通代码块
        {
            System.out.println("子类的代码块");
        }
    }


    public Son(String name){
        super();
        this.name = name;
        System.out.println("子类的含参构造");

    }
}
