package com.simple.javabase.generic.demo1;

/**
 * @author WuChengXing
 * @date 2021/7/27
 */
public interface Operation<T extends Fruit> {
    <T extends Fruit> T Processing(T fruit);
}
