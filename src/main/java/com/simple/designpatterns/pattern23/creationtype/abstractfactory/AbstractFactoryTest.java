package com.simple.designpatterns.pattern23.creationtype.abstractfactory;

import com.simple.designpatterns.pattern23.creationtype.abstractfactory.factory.ComputerFactory;
import com.simple.designpatterns.pattern23.creationtype.abstractfactory.factory.ProduceFactory;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/15 18:19
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        // 获取到 屏幕的生产工厂
        ComputerFactory monitorFactory = ProduceFactory.create("mf");
        // 获取到 曲面屏
        Monitor qmp = monitorFactory.getMonitor("q");
        //开始生产
        qmp.createMonitor();
        Monitor ips = monitorFactory.getMonitor("i");
        ips.createMonitor();

        ComputerFactory hardDiskFactory = ProduceFactory.create("hdf");
        HardDisk mechanicalHardDisk = hardDiskFactory.getHardDisk("m");
        mechanicalHardDisk.createHardDisk();
        HardDisk ssdHardDisk = hardDiskFactory.getHardDisk("s");
        ssdHardDisk.createHardDisk();
    }
}
