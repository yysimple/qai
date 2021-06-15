package com.simple.designpatterns.pattern23.creationtype.simplefactory.impl;

import com.simple.designpatterns.pattern23.creationtype.simplefactory.Column;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/15 17:39
 */
public class TeeColumn implements Column {

    @Override
    public void storeLiquid() {
        System.out.println("==== 茶壶 ====");
    }
}
