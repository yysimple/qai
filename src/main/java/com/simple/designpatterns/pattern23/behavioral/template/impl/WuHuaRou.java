package com.simple.designpatterns.pattern23.behavioral.template.impl;

import com.simple.designpatterns.pattern23.behavioral.template.Cuisine;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 五花肉
 *
 * @author: WuChengXing
 * @create: 2021-07-04 17:44
 **/
public class WuHuaRou extends Cuisine {
    @Override
    protected void cleaning() {
        System.out.println("=== 烫一下猪皮，清洗一下，切成块 ===");
    }

    @Override
    protected void doCooking() {
        System.out.println("=== 红烧，然后开始炖 ===");
    }

    @Override
    protected void finish() {
        System.out.println("=== 完成制作，撒点葱花，上菜 ===");
    }
}
