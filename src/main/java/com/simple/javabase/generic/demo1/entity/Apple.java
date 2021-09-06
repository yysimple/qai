package com.simple.javabase.generic.demo1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author WuChengXing
 * @date 2021/7/27
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Apple extends TypeBlock {
    private String size;

}