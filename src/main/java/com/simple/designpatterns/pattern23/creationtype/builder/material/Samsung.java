package com.simple.designpatterns.pattern23.creationtype.builder.material;

import com.simple.designpatterns.pattern23.creationtype.builder.constant.BuilderConstant;

import java.math.BigDecimal;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-19 00:03
 **/
public class Samsung extends Memory {

    protected Samsung(String brand, BigDecimal price, String size, String desc) {
        super(brand, price, size, desc);
    }

    protected Samsung(String brand, BigDecimal price, String size) {
        this(brand, price, size, "三星-性能好，我不会爆炸的...");
    }

    /**
     * 这些类可以抽出来 结合抽象工厂来实现 分为不同的 类型模板，这里用的是 工厂方法
     */
    static class SamsungFactory {
        public static Memory create(String level) {
            if (BuilderConstant.LEVEL_HIGH.equals(level)) {
                return getHighIntel();
            } else if (BuilderConstant.LEVEL_MID.equals(level)) {
                return getMidIntel();
            } else if (BuilderConstant.LEVEL_LOW.equals(level)) {
                return getLowIntel();
            } else {
                return null;
            }
        }

        public static Samsung getHighIntel() {
            return new Samsung("Samsung-DDR4-3200", new BigDecimal("1200"), "32GB");
        }

        public static Samsung getMidIntel() {
            return new Samsung("Samsung-DDR4-2666", new BigDecimal("1100"), "32GB");
        }

        public static Samsung getLowIntel() {
            return new Samsung("Samsung-DDR4-2666", new BigDecimal("600"), "16GB");
        }
    }
}
