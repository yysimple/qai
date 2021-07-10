package com.simple.designpatterns.pattern23.behavioral.intermediary.two;

import com.simple.designpatterns.pattern23.behavioral.intermediary.two.impl.Tenant;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 中介者模式
 *
 * @author: WuChengXing
 * @create: 2021-07-11 01:06
 **/
public class IntermediaryTest {
    public static void main(String[] args) {
        Xiaoliu xiaoliu = new Xiaoliu();

        Tenant zs = new Tenant("张三", true);
        xiaoliu.viewHouse(zs);
        System.out.println("--------------------");
        Tenant ls = new Tenant("李四", false);
        xiaoliu.viewHouse(ls);

    }
}
