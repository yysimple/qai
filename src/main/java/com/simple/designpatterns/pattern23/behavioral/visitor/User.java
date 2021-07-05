package com.simple.designpatterns.pattern23.behavioral.visitor;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-07-05 23:04
 **/
public abstract class User {
    public String name;

    public String identity;

    public String clazz;

    public User(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }

    /**
     * 访问者的核心接口
     * @param visitor
     */
    protected abstract void accept(Visitor visitor);
}
