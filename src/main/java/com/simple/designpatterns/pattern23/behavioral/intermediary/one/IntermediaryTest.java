package com.simple.designpatterns.pattern23.behavioral.intermediary.one;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 中介者
 *
 * @author: WuChengXing
 * @create: 2021-06-29 10:23
 **/
public class IntermediaryTest {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
