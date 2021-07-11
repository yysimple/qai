package com.simple.designpatterns.design6.isp.impl;

import com.simple.designpatterns.design6.isp.RiceColumn;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 麻袋
 *
 * @author: WuChengXing
 * @create: 2021-07-11 16:03
 **/
public class Sack implements RiceColumn {
    @Override
    public void storeRice() {
        System.out.println("===== 村粗大米 ======");
    }
}
