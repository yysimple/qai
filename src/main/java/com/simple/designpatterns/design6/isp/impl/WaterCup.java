package com.simple.designpatterns.design6.isp.impl;

import com.simple.designpatterns.design6.isp.WaterColumn;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 水杯
 *
 * @author: WuChengXing
 * @create: 2021-07-11 16:02
 **/
public class WaterCup implements WaterColumn {
    @Override
    public void storeWater() {
        System.out.println("====== 装水 =======");
    }
}
