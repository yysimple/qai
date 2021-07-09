package com.simple.designpatterns.pattern23.structuretype.exterior.two;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 订单系统
 *
 * @author: WuChengXing
 * @create: 2021-07-10 00:44
 **/
public class OrderSystem {

    PaySdk paySdk;

    public OrderSystem(PaySdk paySdk) {
        this.paySdk = paySdk;
    }

    public void placeOrderAliPay(){
        System.out.println("=== 下单 ===");
        System.out.println("=== 下单成功，使用支付宝支付 ===");
        paySdk.aliPay();
    }

    public void placeOrderWxPay(){
        System.out.println("=== 下单 ===");
        System.out.println("=== 下单成功，使用微信支付 ===");
        paySdk.wxPay();
    }
}
