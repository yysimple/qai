package com.simple.designpatterns.pattern23.creationtype.builder.material;

import java.math.BigDecimal;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/18 10:27
 */
public class Disk extends Material{

    protected Disk(String brand, BigDecimal price, String size, String desc) {
        super(brand, price, size, desc);
    }
}
