package com.fang.user.test;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.test
 * @author:fxm
 * @createTime:2021/8/30 18:03
 * @version:1.0
 */
public class Father {
    private Integer age;
    static {
        System.out.println("父类的静态代码块");
    }
    {
        // 父类的构造代码块
        System.out.println("父类的构造代码块");
    }

    //无参构造
    public Father() {
        this(20);
        System.out.println("父类的无参构造方法");
        // 普通代码块
        {
            System.out.println("父类的代码块");
        }

    }

    public Father(Integer age) {
        super();
        this.age = age;
        System.out.println("父类的含参构造方法");

    }
}
