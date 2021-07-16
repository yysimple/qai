package com.simple.designpatterns.pattern23.structuretype.exterior.one;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 外观模式
 *
 * @author: WuChengXing
 * @create: 2021-06-27 10:37
 **/
public class ExteriorTest {
    public static void main(String[] args) {

        /**
         * 外观模式，我的理解就是，尽量减少代码的侵入性，做一个独立的项目部署，对需要使用的人来说，都是
         * 开放一个接口去使用，这样会降低 调用放的 风险性，其实就是解耦
         */
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
