package com.fang.user.design.prototype;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.prototype
 * @author:fxm
 * @createTime:2021/8/27 10:40
 * @version:1.0
 */
public class ConcretePrototype extends Prototype{


    @Override
    void draw() {
        System.out.println("Inside ConcretePrototype::draw() method.");
    }

    public ConcretePrototype(){
        type = "ConcretePrototype";
    }
}
