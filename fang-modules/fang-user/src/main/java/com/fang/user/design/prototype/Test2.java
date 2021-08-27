package com.fang.user.design.prototype;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.prototype
 * @author:fxm
 * @createTime:2021/8/27 10:27
 * @version:1.0
 */
public class Test2 {

    public static void main(String[] args) throws CloneNotSupportedException {

        ConcretePrototype cp = new ConcretePrototype();
        for(int i=0; i< 10; i++){
            ConcretePrototype clonecp = (ConcretePrototype)cp.clone();
            System.out.println(clonecp);
            ConcretePrototype clonecp2 = (ConcretePrototype)cp.deepClone();
            System.out.println(clonecp2);
        }
    }
}
