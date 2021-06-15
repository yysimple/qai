package com.simple.designpatterns.pattern23.creationtype.abstractfactory.factory;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/15 18:16
 */
public class ProduceFactory {

    public static ComputerFactory create(String type) {
        if ("mf".equals(type)) {
            System.out.println("-------- 联系屏幕工厂 --------");
            return new MonitorFactory();
        } else if ("hdf".equals(type)) {
            System.out.println("-------- 联系硬盘工厂 --------");
            return new HardDiskFactory();
        }
        return null;
    }
}
