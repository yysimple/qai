package com.simple.designpatterns.design6.srp;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 单一职责
 *
 * @author: WuChengXing
 * @create: 2021-07-11 12:02
 **/
public class SingleResponsibility {
    public static void main(String[] args) {
        System.out.println();
        /**
         * 一个装油的油壶，我们就不应该在赋予他装饮用水的功能，那这样每次我们用的时候还需要最前置的清洗，这样功能混在一起，需要花费很多时间去维护，这样得不偿失！
         */
        /**
         * class OilColumn{
         *     void store(){
         *         System.out.println("=== 装油 ===");
         *     }
         * }
         *
         * class WaterColumn{
         *     void store(){
         *         System.out.println(=== 装水 ===);
         *     }
         * }
         *
         *
         */

        /**
         * 这里调用即可，想用那个功能，就是用哪个对应的功能类
         */
    }
}
