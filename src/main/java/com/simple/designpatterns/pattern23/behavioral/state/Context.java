package com.simple.designpatterns.pattern23.behavioral.state;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 用来记录每种不同状态的上下文
 *
 * @author: WuChengXing
 * @create: 2021-07-04 10:40
 **/
public class Context {
    private State state;

    public Context() {
        this.state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
