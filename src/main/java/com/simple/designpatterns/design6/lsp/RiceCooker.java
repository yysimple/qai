package com.simple.designpatterns.design6.lsp;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/8 14:00
 */
public interface RiceCooker {
    /**
     * 蒸米饭
     *
     * @param material
     */
    void steamedRice(String material);

    /**
     * 煲粥
     *
     * @param material
     */
    void porridge(String material);
}
