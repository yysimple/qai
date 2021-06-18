package com.simple.designpatterns.pattern23.creationtype.builder.material;

import com.simple.designpatterns.pattern23.creationtype.builder.constant.BuilderConstant;

import java.math.BigDecimal;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/18 10:29
 */
public class Intel extends CPU {

    protected Intel(String brand, BigDecimal price, String size, String desc) {
        super(brand, price, size, desc);
    }

    protected Intel(String brand, BigDecimal price, String size) {
        this(brand, price, size, "Intel-我就是喜欢挤牙膏...");
    }

    static class IntelFactory {
        public static CPU create(String level) {
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

        public static Intel getHighIntel() {
            return new Intel("Intel-i9750H", new BigDecimal("2000"), "标压");
        }

        public static Intel getMidIntel() {
            return new Intel("Intel-i8750H", new BigDecimal("1500"), "标压");
        }

        public static Intel getLowIntel() {
            return new Intel("Intel-U5500", new BigDecimal("800"), "低压");
        }
    }
}
