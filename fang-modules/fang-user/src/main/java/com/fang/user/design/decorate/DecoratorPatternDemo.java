package com.fang.user.design.decorate;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.decorate
 * @author:fxm
 * @createTime:2021/8/27 16:13
 * @version:1.0
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Redtangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
