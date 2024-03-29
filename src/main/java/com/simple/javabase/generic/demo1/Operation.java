package com.simple.javabase.generic.demo1;

import com.simple.javabase.generic.demo1.entity.Fruit;

/**
 * @author WuChengXing
 * @date 2021/7/27
 */
public interface Operation<T extends Fruit> {
    T Processing(T fruit);
}
