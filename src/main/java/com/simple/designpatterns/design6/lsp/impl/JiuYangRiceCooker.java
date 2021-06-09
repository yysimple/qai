package com.simple.designpatterns.design6.lsp.impl;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/9 9:47
 */
public class JiuYangRiceCooker extends NormalRiceCooker{


    /**
     * 特殊的煲粥方式
     * @param material
     */
    public void specialPorridge(String material) {
        System.out.println("=== " + material + ",放入，不用管了，20分钟后喝粥===");
    }
}
