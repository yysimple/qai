package com.simple.designpatterns.pattern23.creationtype.builder;

import com.simple.designpatterns.pattern23.creationtype.builder.constant.BuilderConstant;
import com.simple.designpatterns.pattern23.creationtype.builder.material.ComputerBuilder;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/17 15:18
 */
public class BuilderTest {
    public static void main(String[] args) {
        ComputerBuilder.builder(BuilderConstant.LEVEL_LOW);
        ComputerBuilder.builder(BuilderConstant.LEVEL_MID);
        ComputerBuilder.builder(BuilderConstant.LEVEL_HIGH);
    }
}
