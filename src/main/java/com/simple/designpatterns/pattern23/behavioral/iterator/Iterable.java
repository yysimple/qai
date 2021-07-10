package com.simple.designpatterns.pattern23.behavioral.iterator;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-28 23:39
 **/
public interface Iterable {
    /**
     * 获取迭代器
     * @return
     */
    Iterator getIterator();
}
