package com.simple.designpatterns.pattern23.structuretype.exterior.two;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 外观模式测试
 *
 * @author: WuChengXing
 * @create: 2021-07-10 00:32
 **/
public class ExteriorTest {
    public static void main(String[] args) {
        OrderSystem orderSystem = new OrderSystem(new PaySdk());
        System.out.println("----------- shopping -----------");
        orderSystem.placeOrderAliPay();
        System.out.println("----------- shopping -----------");
        orderSystem.placeOrderWxPay();
    }
}
