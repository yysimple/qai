package com.simple.designpatterns.pattern23.behavioral.responsibilitychain.impl;

import com.simple.designpatterns.pattern23.behavioral.responsibilitychain.AbstractLogger;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-28 00:13
 **/
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("info--[级别为 1]: " + message);
    }
}
