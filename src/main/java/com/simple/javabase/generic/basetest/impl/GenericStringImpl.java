package com.simple.javabase.generic.basetest.impl;

import com.simple.javabase.generic.basetest.GenericService;

/**
 * 当泛型实例化的时候，其实现类中所有的 泛型 都需要换成指定的类型 即传入 String，其他方法上的 T 也需要全部替换成 String
 *
 *
 * @author WuChengXing
 * @date 2021/7/20
 */
public class GenericStringImpl implements GenericService<String> {

    @Override
    public String next(String a) {
        return a + "-泛型测试-String实现";
    }
}
