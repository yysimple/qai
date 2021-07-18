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
    /**
     * 初始化拦截链规则
     *
     * @return
     */
    private static AbstractLogger initChain() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        /**
         * 这里的关系是：
         *  info：只能打印info级别的日志，对应等级 1
         *  debug：可以打印info、debug两种级别的日志，对应等级 2
         *  error：可打印info、debug、error三种级别的日志，对应等级 3
         *
         *  这里对用的就是，如果级别为 error的时候，可能会输出到三个地方，比如 文件、控制台等
         */
        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = initChain();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
        System.out.println("---------------------");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");
        System.out.println("---------------------");
        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}
