package com.simple.designpatterns.design6.isp;

import com.simple.designpatterns.design6.isp.impl.Sack;
import com.simple.designpatterns.design6.isp.impl.WaterCup;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/10 18:10
 */
public class IspTest {
    /**
     * 接口隔离原则：就是尽量让每个接口有自己独特的能力，不能将所有能力放在一个接口里，会使其维护和扩展变得非常艰难
     */
    public static void main(String[] args) {
        WaterColumn waterColumn = new WaterCup();
        waterColumn.storeWater();
        System.out.println("---------------------");
        RiceColumn riceColumn = new Sack();
        riceColumn.storeRice();
    }
}
