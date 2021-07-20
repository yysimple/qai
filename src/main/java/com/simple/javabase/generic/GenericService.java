package com.simple.javabase.generic;

/**
 * @author WuChengXing
 * @date 2021/7/20
 */
public interface GenericService<T> {
    T next(T t);
}
