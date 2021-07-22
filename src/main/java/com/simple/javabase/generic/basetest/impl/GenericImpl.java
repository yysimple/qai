package com.simple.javabase.generic.basetest.impl;

import com.simple.javabase.generic.basetest.GenericService;

/**
 * GenericImpl implements GenericService<T>：
 *  这种方式编译不会通过，其实现类也需要要加上泛型
 *
 * @author WuChengXing
 * @date 2021/7/20
 */
public class GenericImpl<T> implements GenericService<T> {

    @Override
    public T next(T t) {
        return (T) (t + "泛型测试-调用者传入,类型 ==> : " + t.getClass());
    }
}
