package com.simple.designpatterns.pattern23.structuretype.flyweight;

import java.util.HashMap;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-27 11:20
 **/
public class ShapeFactory {
    // 用来存放通用的对象，类似可以做缓存的存储容器都可以使用，redis也可以
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            // 将创建过的对象放入缓存中使用
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
