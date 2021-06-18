package com.simple.designpatterns.pattern23.creationtype.builder.material;

import com.simple.designpatterns.pattern23.creationtype.builder.material.Material;

import java.math.BigDecimal;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/18 10:26
 */
public class Motherboard extends Material {

    protected Motherboard(String brand, BigDecimal price, String size, String desc) {
        super(brand, price, size, desc);
    }
}