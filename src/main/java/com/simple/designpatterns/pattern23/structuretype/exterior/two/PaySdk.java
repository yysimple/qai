package com.simple.designpatterns.pattern23.structuretype.exterior.two;

import com.simple.designpatterns.pattern23.structuretype.exterior.two.impl.AliPay;
import com.simple.designpatterns.pattern23.structuretype.exterior.two.impl.WxPay;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 支付SDK
 *
 * @author: WuChengXing
 * @create: 2021-07-10 00:39
 **/
public class PaySdk {
    private Pay aliPay;
    private Pay wxPay;

    public PaySdk() {
        this.aliPay = new AliPay();
        this.wxPay = new WxPay();
    }

    /**
     * 支付宝支付
     */
    public void aliPay(){
        aliPay.aliPay();
    }

    /**
     * 微信支付
     */
    public void wxPay(){
        wxPay.wxPay();
    }
}
