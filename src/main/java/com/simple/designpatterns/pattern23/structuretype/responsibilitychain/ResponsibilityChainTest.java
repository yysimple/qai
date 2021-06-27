package com.simple.designpatterns.pattern23.structuretype.responsibilitychain;

import com.simple.designpatterns.pattern23.structuretype.responsibilitychain.impl.ConsoleLogger;
import com.simple.designpatterns.pattern23.structuretype.responsibilitychain.impl.ErrorLogger;
import com.simple.designpatterns.pattern23.structuretype.responsibilitychain.impl.FileLogger;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 责任链
 *
 * @author: WuChengXing
 * @create: 2021-06-28 00:08
 **/
public class ResponsibilityChainTest {
    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}
