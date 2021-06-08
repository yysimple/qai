package com.simple.designpatterns.design6.ocp;

import com.simple.designpatterns.design6.ocp.impl.FeeServiceImpl;
import com.simple.designpatterns.design6.ocp.impl.SpecialFinanceFee;

/**
 * @author chengxing.wu
 * @date 2021/6/7 23:02
 */
public class OcpTest {
    public static void main(String[] args) {
        FeeService feeService = new SpecialFinanceFee();
        System.out.println(feeService.getFinancialFee("2"));
        FeeService feeService1 = new FeeServiceImpl();
        System.out.println(feeService1.getFinancialFee("2"));
    }
}
