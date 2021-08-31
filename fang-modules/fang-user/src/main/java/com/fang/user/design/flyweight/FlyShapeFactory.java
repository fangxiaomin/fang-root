package com.fang.user.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.flyweight
 * @author:fxm
 * @createTime:2021/8/31 16:56
 * @version:1.0
 */
public class FlyShapeFactory {

    private static final Map<String, FlyCircle> circleMap = new HashMap<>();

    public static FlyCircle getFlyCircle(String color){
        FlyCircle flyCircle = circleMap.get(color);
        if(flyCircle == null ){
            flyCircle = new FlyCircle(color);
            circleMap.put(color,flyCircle);
            System.out.println("Creating circle of color : " + color);
        }
        return flyCircle;
    }


}
