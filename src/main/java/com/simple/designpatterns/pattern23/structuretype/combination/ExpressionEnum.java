package com.simple.designpatterns.pattern23.structuretype.combination;

import lombok.Getter;

import java.net.Inet4Address;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 表达式枚举
 *
 * @author: WuChengXing
 * @create: 2021-06-26 13:27
 **/
@Getter
public enum ExpressionEnum {

    EQUAL(1, "等于"),
    GRANT(2, "大于"),
    LESS(3, "小于"),
    LESS_EQUAL(4, "小于等于"),
    GRANT_EQUAL(5, "大于等于"),
    ;

    ExpressionEnum(Integer index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    private final Integer index;

    private final String desc;

    public static ExpressionEnum getByIndex(Integer index) {
        for (ExpressionEnum expressionEnum : values()) {
            if (index.equals(expressionEnum.getIndex())) {
                return expressionEnum;
            }
        }
        return null;
    }
}
