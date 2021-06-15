package com.simple.designpatterns.pattern23.creationtype.abstractfactory.impl;

import com.simple.designpatterns.pattern23.creationtype.abstractfactory.Monitor;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/15 18:02
 */
public class QmpMonitor implements Monitor {
    @Override
    public void createMonitor() {
        System.out.println("==== 生产曲面屏 ====");
    }
}
