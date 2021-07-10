package com.simple.designpatterns.pattern23.behavioral.intermediary.two;

import com.simple.designpatterns.pattern23.behavioral.intermediary.two.impl.CommonRenting;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 房东-只负责签合同
 *
 * @author: WuChengXing
 * @create: 2021-07-11 01:06
 **/
public class Landlord extends CommonRenting {
    @Override
    public void signContract() {
        System.out.println("房东：小刘啊，租出去了啊，我带合同来了，水4块钱一吨，电费1.3元，租金2500，来支付宝付钱");
    }
}
