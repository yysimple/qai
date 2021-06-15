package com.simple.designpatterns.pattern23.creationtype.abstractfactory.impl;

import com.simple.designpatterns.pattern23.creationtype.abstractfactory.HardDisk;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/15 18:07
 */
public class SSDHardDisk implements HardDisk {
    @Override
    public void createHardDisk() {
        System.out.println("==== 生产ssd硬盘 ====");
    }
}
