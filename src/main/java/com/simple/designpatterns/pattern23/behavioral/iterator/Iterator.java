package com.simple.designpatterns.pattern23.behavioral.iterator;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 迭代器抽象接口
 *
 * @author: WuChengXing
 * @create: 2021-06-28 23:38
 **/
public interface Iterator {
    /**
     * 校验是否有下一个袁4元素
     * @return
     */
    boolean hasNext();

    /**
     * 下一个元素
     * @return
     */
    Object next();
}
