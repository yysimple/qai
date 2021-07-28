package com.simple.javabase.generic.demo1;

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
public class Apple extends Fruit {
    private String type;


}
