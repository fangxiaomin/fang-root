package com.fang.user.design.flyweight;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.flyweight
 * @author:fxm
 * @createTime:2021/8/31 16:53
 * @version:1.0
 */
public class FlyCircle {

    //共有属性
    private String color;
    private int x;
    private int y;
    private int radius;
    //  根据颜色去觉得那个对象

    public FlyCircle(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
                + ", x : " + x + ", y : " + y + ", radius : " + radius);
    }
}
