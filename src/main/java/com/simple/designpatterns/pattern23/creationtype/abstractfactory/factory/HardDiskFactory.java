package com.simple.designpatterns.pattern23.creationtype.abstractfactory.factory;

import com.simple.designpatterns.pattern23.creationtype.abstractfactory.HardDisk;
import com.simple.designpatterns.pattern23.creationtype.abstractfactory.impl.MechanicalHardDisk;
import com.simple.designpatterns.pattern23.creationtype.abstractfactory.impl.SSDHardDisk;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/15 18:10
 */
public class HardDiskFactory extends CommonFactory {

    /**
     * 这里不关心屏幕的生产
     *
     * @param type
     * @return
     */
    @Override
    public HardDisk getHardDisk(String type) {
        if ("m".equals(type)) {
            System.out.println("xxxxxxxx 准备生产机械硬盘 xxxxxxxx");
            return new MechanicalHardDisk();
        } else if ("s".equals(type)) {
            System.out.println("xxxxxxxx 准备生产机SSD硬盘 xxxxxxxx");
            return new SSDHardDisk();
        }
        return null;
    }
}
