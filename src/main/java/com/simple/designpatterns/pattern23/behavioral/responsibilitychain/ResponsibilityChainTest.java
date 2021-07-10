package com.simple.designpatterns.pattern23.behavioral.responsibilitychain;

import com.simple.designpatterns.pattern23.behavioral.responsibilitychain.impl.ConsoleLogger;
import com.simple.designpatterns.pattern23.behavioral.responsibilitychain.impl.ErrorLogger;
import com.simple.designpatterns.pattern23.behavioral.responsibilitychain.impl.DebugLogger;

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
        AbstractLogger fileLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
        System.out.println("---------------------");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");
        System.out.println("---------------------");
        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}
