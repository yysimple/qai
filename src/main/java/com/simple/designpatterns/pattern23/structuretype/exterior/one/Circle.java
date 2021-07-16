package com.simple.designpatterns.pattern23.structuretype.exterior.one;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-27 10:41
 **/
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Circle.draw");
    }
}
