package com.simple.designpatterns.pattern23.creationtype.builder.material;

import com.simple.designpatterns.pattern23.creationtype.builder.constant.BuilderConstant;

import java.math.BigDecimal;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-18 23:54
 **/
public class Kingston extends Disk {

    protected Kingston(String brand, BigDecimal price, String size, String desc) {
        super(brand, price, size, desc);
    }

    protected Kingston(String brand, BigDecimal price, String size) {
        this(brand, price, size, "金士顿-性能好，就是稍微贵点...");
    }

    static class KingstonFactory {
        public static Disk create(String level) {
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

        public static Kingston getHighIntel() {
            return new Kingston("Kingston-m.2-a400", new BigDecimal("700"), "1024GB");
        }

        public static Kingston getMidIntel() {
            return new Kingston("Kingston-m.2-sata总线", new BigDecimal("380"), "512GB");
        }

        public static Kingston getLowIntel() {
            return new Kingston("Kingston-sata3.0", new BigDecimal("300"), "512GB");
        }
    }
}
