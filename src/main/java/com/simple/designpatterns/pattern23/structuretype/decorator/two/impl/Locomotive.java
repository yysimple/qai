package com.simple.designpatterns.pattern23.structuretype.decorator.two.impl;

import com.simple.designpatterns.pattern23.structuretype.decorator.two.Car;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 机车
 *
 * @author: WuChengXing
 * @create: 2021-07-09 23:40
 **/
public class Locomotive implements Car {

    @Override
    public void drive() {
        System.out.println("=== 开着我装逼大机车... ===");
    }
}
