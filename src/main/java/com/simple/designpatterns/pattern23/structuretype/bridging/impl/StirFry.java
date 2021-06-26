package com.simple.designpatterns.pattern23.structuretype.bridging.impl;

import com.simple.designpatterns.pattern23.structuretype.bridging.CookingMethod;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 爆炒
 *
 * @author: WuChengXing
 * @create: 2021-06-26 10:26
 **/
public class StirFry implements CookingMethod {

    @Override
    public String doThings() {
        System.out.println("=== 放入大料中开始爆炒 ===");
        return "爆炒";
    }
}
