package com.simple.designpatterns.pattern23.structuretype.bridging.impl;

import com.simple.designpatterns.pattern23.structuretype.bridging.CookingMethod;
import com.simple.designpatterns.pattern23.structuretype.bridging.Cuisine;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 米粉
 *
 * @author: WuChengXing
 * @create: 2021-06-26 10:24
 **/
public class RiceFlour extends Cuisine {

    /**
     * 引申出一个问题：为什么子类一定要先调用父类的构造器去协助完成初始化？
     * 道理很简单，就是有一些字段需要父类自己去完成初始化，然后子类才可以去使用
     *
     * @param cookingMethod
     */
    public RiceFlour(CookingMethod cookingMethod) {
        super(cookingMethod);
    }

    @Override
    public void finishedProduct() {
        System.out.println("=== 清洗米粉、浸泡一段时间 ===");
        String name = cookingMethod.doThings();
        System.out.println("=== 制作完成, " + name + "米粉 ===");
    }
}
