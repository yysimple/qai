package com.simple.designpatterns.pattern23.behavioral.intermediary.two;

import com.simple.designpatterns.pattern23.behavioral.intermediary.two.impl.Tenant;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 租房子
 *
 * @author: WuChengXing
 * @create: 2021-07-11 01:07
 **/
public interface Renting {

    /**
     * 看房子
     */
    void viewHouse(Tenant tenant);

    /**
     * 签合同
     */
    void signContract();

    /**
     * --- 其他过程 ---
     */
}
