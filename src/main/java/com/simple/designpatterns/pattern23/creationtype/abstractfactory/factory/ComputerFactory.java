package com.simple.designpatterns.pattern23.creationtype.abstractfactory.factory;

import com.simple.designpatterns.pattern23.creationtype.abstractfactory.HardDisk;
import com.simple.designpatterns.pattern23.creationtype.abstractfactory.Monitor;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/15 17:50
 */
public abstract class ComputerFactory {
    /**
     * 抽象工厂，电脑工厂既可以生产屏幕，又可以生产硬盘，但是这些都交给对应的厂商去做，自己不做（有子类工厂去做）
     *
     * @param type
     * @return
     */
    public abstract Monitor getMonitor(String type);

    public abstract HardDisk getHardDisk(String type);
}
