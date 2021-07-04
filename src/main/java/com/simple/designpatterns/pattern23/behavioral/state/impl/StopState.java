package com.simple.designpatterns.pattern23.behavioral.state.impl;

import com.simple.designpatterns.pattern23.behavioral.state.Context;
import com.simple.designpatterns.pattern23.behavioral.state.State;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 停止状态
 *
 * @author: WuChengXing
 * @create: 2021-07-04 10:42
 **/
public class StopState implements State {

    private Context context;

    @Override
    public void doSomeThing(Context context) {
        System.out.println("=== 我是结束状态，我要关闭整个下单流程了 ===");
        context.setState(this);
    }

    public String toString(){
        return "stop state";
    }
}
