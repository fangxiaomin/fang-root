package com.fang.user.design.decorate;

/**
 * @description:  实现了 Shape 接口的抽象装饰类。
 * @version:1.0
 */
public abstract class ShapeDecorator implements Shape{

    protected Shape decoratorShape;

    public ShapeDecorator(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    @Override
    public void draw() {
        decoratorShape.draw();
    }

}
