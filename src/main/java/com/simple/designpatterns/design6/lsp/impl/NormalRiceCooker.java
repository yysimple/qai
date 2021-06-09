package com.simple.designpatterns.design6.lsp.impl;

import com.simple.designpatterns.design6.lsp.RiceCooker;

/**
 * @author chengxing.wu
 * @date 2021/6/8 14:03
 */
public class NormalRiceCooker implements RiceCooker {

    @Override
    public void steamedRice(String material) {
        System.out.println("=== 开始蒸米饭 ===");
        System.out.println("=== 加入" + material + "===");
        System.out.println("=== 按下开关 ===");
        System.out.println("=== 蒸米饭中... ===");
        System.out.println("=== 跳闸 ===");
    }

    @Override
    public void porridge(String material) {
        System.out.println("=== 开始煲粥 ===");
        System.out.println("=== 加入" + material + "===");
        System.out.println("=== 按下开关 ===");
        System.out.println("=== 煲粥中... ===");
        System.out.println("=== 检查一下粥的情况（是否太稀了）... ===");
        System.out.println("=== 不用等跳闸，觉得可以就ok ===");
    }
}
