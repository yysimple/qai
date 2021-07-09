package com.simple.designpatterns.pattern23.structuretype.exterior.two.impl;

import com.simple.designpatterns.pattern23.structuretype.exterior.two.CommonPay;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 支付宝付款
 *
 * @author: WuChengXing
 * @create: 2021-07-10 00:36
 **/
public class AliPay extends CommonPay {
    @Override
    public void aliPay() {
        System.out.println("=== 组装各类配置：公钥、私钥 ===");
        System.out.println("=== 开始调用支付宝SDK ===");
        System.out.println("=== 支付完成 ===");
    }
}
