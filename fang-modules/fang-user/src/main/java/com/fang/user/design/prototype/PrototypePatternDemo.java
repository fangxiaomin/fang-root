package com.fang.user.design.prototype;

import javafx.scene.shape.Circle;

import java.util.Hashtable;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.prototype
 * @author:fxm
 * @createTime:2021/8/27 11:12
 * @version:1.0
 */
public class PrototypePatternDemo {

    private static Hashtable<String, Prototype> shapeMap = new Hashtable<>();

    public static Prototype getShape(String shapeId) {
        Prototype cachedShape = shapeMap.get(shapeId);
        return (Prototype) cachedShape.clone();
    }

    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);
    // 例如，我们要添加三种形状
    public static void loadCache() {
        ConcretePrototype circle = new ConcretePrototype();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }


    public static void main(String[] args) {
        PrototypePatternDemo.loadCache();
        //根据某一个变量 去生成对象
        Prototype clonedShape = (Prototype) PrototypePatternDemo.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());
        Prototype clonedShape2 = (Prototype) PrototypePatternDemo.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());
        Prototype clonedShape3 = (Prototype) PrototypePatternDemo.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());



    }
}
