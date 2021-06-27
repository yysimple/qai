package com.simple.designpatterns.pattern23.structuretype.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: mapper文件映射代理
 *
 * @author: WuChengXing
 * @create: 2021-06-27 12:56
 **/
@Slf4j
public class MapperFactoryBean<T> implements FactoryBean<T> {

    private MapperInvocationHandler mapperInvocationHandler;

    private Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, new MapperInvocationHandler());
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
