package com.simple.designpatterns.pattern23.structuretype.proxy.one;

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

    private Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * 这是生成代理类的过程，针对于 UserMapper，只是一个接口，然后生成其代理类去完成真正的逻辑（MapperInvocationHandler）
     * 然后将这个生成的代理类注入到spring容器之中，便可以使用了
     * @return
     * @throws Exception
     */
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
