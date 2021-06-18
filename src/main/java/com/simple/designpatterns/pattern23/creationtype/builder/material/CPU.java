package com.simple.designpatterns.pattern23.creationtype.builder.material;

import com.simple.designpatterns.pattern23.creationtype.builder.material.Material;

import java.math.BigDecimal;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/18 10:12
 */
public class CPU extends Material {

    protected CPU(String brand, BigDecimal price, String size, String desc) {
        super(brand, price, size, desc);
    }
}
