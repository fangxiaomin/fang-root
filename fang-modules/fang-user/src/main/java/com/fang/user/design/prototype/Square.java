package com.fang.user.design.prototype;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.prototype
 * @author:fxm
 * @createTime:2021/8/27 10:59
 * @version:1.0
 */
public class Square extends Prototype{
    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }

    public Square(){
        type = "Square";
    }
}
