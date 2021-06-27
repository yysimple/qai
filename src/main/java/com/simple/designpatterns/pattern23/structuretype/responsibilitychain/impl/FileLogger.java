package com.simple.designpatterns.pattern23.structuretype.responsibilitychain.impl;

import com.simple.designpatterns.pattern23.structuretype.responsibilitychain.AbstractLogger;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-28 00:15
 **/
public class FileLogger extends AbstractLogger {
    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
