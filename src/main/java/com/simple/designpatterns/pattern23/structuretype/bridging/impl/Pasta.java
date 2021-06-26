package com.simple.designpatterns.pattern23.structuretype.bridging.impl;

import com.simple.designpatterns.pattern23.structuretype.bridging.CookingMethod;
import com.simple.designpatterns.pattern23.structuretype.bridging.Cuisine;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 面食
 *
 * @author: WuChengXing
 * @create: 2021-06-26 10:23
 **/
public class Pasta extends Cuisine {

    public Pasta(CookingMethod cookingMethod) {
        super(cookingMethod);
    }

    @Override
    public void finishedProduct() {
        System.out.println("=== 擀面、醒面、清洗面 ===");
        String name = cookingMethod.doThings();
        System.out.println("=== 制作完成, " + name + "面 ===");
    }
}
