package com.simple.designpatterns.pattern23.behavioral.template;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 菜品
 *
 * @author: WuChengXing
 * @create: 2021-07-04 16:16
 **/
public abstract class Cuisine {
    /**
     * 清洗菜/处理菜
     */
    protected abstract void cleaning();

    /**
     * 开始做菜
     */
    protected abstract void doCooking();

    /**
     * 菜品制作完成
     */
    protected abstract void finish();

    /**
     * 下单开始制作，最后生成菜品
     */
    public final void placeOrderAndCooking() {
        cleaning();
        doCooking();
        finish();
    }

}
