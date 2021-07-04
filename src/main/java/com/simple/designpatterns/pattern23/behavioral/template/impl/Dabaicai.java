package com.simple.designpatterns.pattern23.behavioral.template.impl;

import com.simple.designpatterns.pattern23.behavioral.template.Cuisine;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 大白菜
 *
 * @author: WuChengXing
 * @create: 2021-07-04 17:42
 **/
public class Dabaicai extends Cuisine {
    @Override
    protected void cleaning() {
        System.out.println("=== 清洗一下大白菜 ===");
    }

    @Override
    protected void doCooking() {
        System.out.println("=== 加点生抽、清炒大白菜 ===");
    }

    @Override
    protected void finish() {
        System.out.println("=== 完成制作，上菜 ===");
    }
}
