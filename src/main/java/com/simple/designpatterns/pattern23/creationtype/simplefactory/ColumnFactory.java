package com.simple.designpatterns.pattern23.creationtype.simplefactory;

import com.simple.designpatterns.pattern23.creationtype.simplefactory.impl.TeeColumn;
import com.simple.designpatterns.pattern23.creationtype.simplefactory.impl.WaterColumn;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/15 17:41
 */
public class ColumnFactory {

    /**
     * 获取对应的功能类
     *
     * @param type
     * @return
     */
    public static Column create(String type) {
        if ("tee".equals(type)) {
            return new TeeColumn();
        } else if ("water".equals(type)) {
            return new WaterColumn();
        }
        return new TeeColumn();
    }
}
