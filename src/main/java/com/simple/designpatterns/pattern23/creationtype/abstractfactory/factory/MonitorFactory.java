package com.simple.designpatterns.pattern23.creationtype.abstractfactory.factory;

import com.simple.designpatterns.pattern23.creationtype.abstractfactory.HardDisk;
import com.simple.designpatterns.pattern23.creationtype.abstractfactory.Monitor;
import com.simple.designpatterns.pattern23.creationtype.abstractfactory.impl.IpsMonitor;
import com.simple.designpatterns.pattern23.creationtype.abstractfactory.impl.QmpMonitor;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/15 17:58
 */
public class MonitorFactory extends ComputerFactory {

    @Override
    public Monitor getMonitor(String type) {
        if ("q".equals(type)) {
            System.out.println("xxxxxxxx 准备生产曲面屏 xxxxxxxx");
            return new QmpMonitor();
        } else if ("i".equals(type)) {
            System.out.println("xxxxxxxx 准备生产IPS屏 xxxxxxxx");
            return new IpsMonitor();
        }
        return null;
    }

    @Override
    public HardDisk getHardDisk(String type) {
        return null;
    }
}
