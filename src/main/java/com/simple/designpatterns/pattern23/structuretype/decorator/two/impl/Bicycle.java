package com.simple.designpatterns.pattern23.structuretype.decorator.two.impl;

import com.simple.designpatterns.pattern23.structuretype.decorator.two.Car;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 自行车
 *
 * @author: WuChengXing
 * @create: 2021-07-09 23:42
 **/
public class Bicycle implements Car {
    @Override
    public void drive() {
        System.out.println("=== 骑着我心爱的小毛驴... ===");
    }
}
