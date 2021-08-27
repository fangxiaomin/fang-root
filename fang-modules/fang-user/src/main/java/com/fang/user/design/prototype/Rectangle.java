package com.fang.user.design.prototype;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.prototype
 * @author:fxm
 * @createTime:2021/8/27 10:59
 * @version:1.0
 */
public class Rectangle extends Prototype{
    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

    public Rectangle(){
        type = "Rectangle";
    }
}
