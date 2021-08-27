package com.fang.user.design.decorate;

/**
 * @description:  创建实现接口的实体类
 * @version:1.0
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
