package com.simple.designpatterns.pattern23.behavioral.template;

import com.simple.designpatterns.pattern23.behavioral.template.impl.Dabaicai;
import com.simple.designpatterns.pattern23.behavioral.template.impl.WuHuaRou;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 模板模式
 *
 * @author: WuChengXing
 * @create: 2021-07-04 16:12
 **/
public class TemplateTest {
    public static void main(String[] args) {
        Cuisine wuHuaRou = new WuHuaRou();
        wuHuaRou.placeOrderAndCooking();
        System.out.println("---------------------------");
        Cuisine dabaicai = new Dabaicai();
        dabaicai.placeOrderAndCooking();
    }
}
