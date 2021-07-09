package com.simple.designpatterns.pattern23.structuretype.exterior.two.impl;

import com.simple.designpatterns.pattern23.structuretype.exterior.two.CommonPay;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 微信支付
 *
 * @author: WuChengXing
 * @create: 2021-07-10 00:38
 **/
public class WxPay extends CommonPay {
    @Override
    public void wxPay() {
        System.out.println("=== 组装各类配置：appid、appkey ===");
        System.out.println("=== 开始调用微信SDK ===");
        System.out.println("=== 支付完成 ===");
    }
}
