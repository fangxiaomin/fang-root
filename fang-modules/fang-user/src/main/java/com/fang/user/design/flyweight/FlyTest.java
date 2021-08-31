package com.fang.user.design.flyweight;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.flyweight
 * @author:fxm
 * @createTime:2021/8/31 16:59
 * @version:1.0
 */
public class FlyTest {

    private static final String[] colors =
            {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; ++i) {
            FlyCircle flyCircle = FlyShapeFactory.getFlyCircle(getRandomColor());
            flyCircle.setRadius(100);
            flyCircle.setX(getRandomX());
            flyCircle.setY(getRandomY());
            flyCircle.draw();
            System.out.println();
        }
    }


    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}
