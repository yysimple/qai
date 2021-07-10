package com.simple.designpatterns.pattern23.behavioral.state;

import com.simple.designpatterns.pattern23.behavioral.state.impl.StartState;
import com.simple.designpatterns.pattern23.behavioral.state.impl.StopState;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 状态模式
 * 每种状态只关心自己的行为，而状态和行为的表示，则交由context上下文去表示，这样看上去是 state这个对象一直在改变
 *
 * @author: WuChengXing
 * @create: 2021-07-04 10:36
 **/
public class StateTest {
    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        StopState stopState = new StopState();
        startState.doSomeThing(context);
        System.out.println(context.getState().toString());
        System.out.println("----------------------------");
        stopState.doSomeThing(context);
        System.out.println(context.getState().toString());
    }
}
