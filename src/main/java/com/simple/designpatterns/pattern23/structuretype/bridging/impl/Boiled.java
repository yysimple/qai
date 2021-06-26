package com.simple.designpatterns.pattern23.structuretype.bridging.impl;

import com.simple.designpatterns.pattern23.structuretype.bridging.CookingMethod;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 水煮
 *
 * @author: WuChengXing
 * @create: 2021-06-26 10:27
 **/
public class Boiled implements CookingMethod {

    @Override
    public String doThings() {
        System.out.println("=== 放入水中开始煮 ===");
        return "水煮";
    }
}
