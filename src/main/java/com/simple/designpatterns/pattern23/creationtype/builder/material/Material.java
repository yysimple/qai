package com.simple.designpatterns.pattern23.creationtype.builder.material;

import java.math.BigDecimal;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/17 15:58
 */
public abstract class Material {
    /**
     * 品牌
     */
    protected String brand;

    /**
     * 价格
     */
    protected BigDecimal price;

    /**
     * 大小
     */
    protected String size;

    /**
     * 描述
     */
    protected String desc;

    protected Material(String brand, BigDecimal price, String size, String desc) {
        this.brand = brand;
        this.price = price;
        this.size = size;
        this.desc = desc;
    }
}
