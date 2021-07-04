package com.simple.designpatterns.pattern23.behavioral.state;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 定义一个状态抽象类，子类根据不用状态去实现不同的行为
 *
 * @author: WuChengXing
 * @create: 2021-07-04 10:36
 **/
public interface State {
    /**
     * 根据不同状态做出不同的行为
     */
    void doSomeThing(Context context);
}
