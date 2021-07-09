package com.simple.designpatterns.pattern23.creationtype.abstractfactory.factory;

import com.simple.designpatterns.pattern23.creationtype.abstractfactory.HardDisk;
import com.simple.designpatterns.pattern23.creationtype.abstractfactory.Monitor;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 公共工厂
 *
 * @author: WuChengXing
 * @create: 2021-07-09 19:01
 **/
public class CommonFactory extends ComputerFactory{
    @Override
    public Monitor getMonitor(String type) {
        return null;
    }

    @Override
    public HardDisk getHardDisk(String type) {
        return null;
    }
}
