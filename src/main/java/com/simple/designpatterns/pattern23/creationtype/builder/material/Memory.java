package com.simple.designpatterns.pattern23.creationtype.builder.material;

import com.simple.designpatterns.pattern23.creationtype.builder.constant.BuilderConstant;

import java.math.BigDecimal;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-18 23:55
 **/
public class Memory extends Material {

    protected Memory(String brand, BigDecimal price, String size, String desc) {
        super(brand, price, size, desc);
    }
}
