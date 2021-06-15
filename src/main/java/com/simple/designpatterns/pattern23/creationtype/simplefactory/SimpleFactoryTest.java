package com.simple.designpatterns.pattern23.creationtype.simplefactory;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/15 17:41
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        /**
         * 通过简单工厂模式可以减少很多代码，其他地方要用的时候，也只需要传入自己想要的功能就行，
         * 不用去关心功能里面具体的实现，这样代码也就能复用了
         */
        Column tee = ColumnFactory.create("tee");
        tee.storeLiquid();
        Column water = ColumnFactory.create("water");
        water.storeLiquid();
    }
}
