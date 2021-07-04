package com.simple.designpatterns.pattern23.behavioral.state.impl;

import com.simple.designpatterns.pattern23.behavioral.state.Context;
import com.simple.designpatterns.pattern23.behavioral.state.State;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 开始状态，有自己的特定行为
 *
 * @author: WuChengXing
 * @create: 2021-07-04 10:39
 **/
public class StartState implements State {
    private Context context;

    @Override
    public void doSomeThing(Context context) {
        System.out.println("=== 我是开始状态，要做一下初始化操作 ===");
        context.setState(this);
    }

    public String toString(){
        return "start state";
    }
}
