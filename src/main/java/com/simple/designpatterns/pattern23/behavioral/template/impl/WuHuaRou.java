package com.simple.designpatterns.pattern23.behavioral.template.impl;

import com.simple.designpatterns.pattern23.behavioral.template.CommonCuisine;
import com.simple.designpatterns.pattern23.behavioral.template.Cuisine;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 五花肉
 *
 * @author: WuChengXing
 * @create: 2021-07-04 17:44
 **/
public class WuHuaRou extends CommonCuisine {

    @Override
    protected void doCooking() {
        System.out.println("=== 好肉，不需要处理，焯水直接红烧，然后开始炖 ===");
    }

    @Override
    protected void finish() {
        System.out.println("=== 完成制作，撒点葱花，拿出82年的老盘子来装菜 ===");
    }
}
