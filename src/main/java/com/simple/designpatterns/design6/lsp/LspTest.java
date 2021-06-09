package com.simple.designpatterns.design6.lsp;

import com.simple.designpatterns.design6.lsp.impl.JiuYangRiceCooker;

/**
 * @author chengxing.wu@xiaobao100.com
 * @date 2021/6/9 9:49
 */
public class LspTest {
    public static void main(String[] args) {
        /**
         * 这里的九阳电饭煲，继承了普通电饭煲的特性，也有了自己的特性，所以是符合 里氏替换原则的
         */
        JiuYangRiceCooker jiuYangRiceCooker = new JiuYangRiceCooker();
        jiuYangRiceCooker.specialPorridge("特殊材料");

        System.out.println("-------------------------------");
        jiuYangRiceCooker.steamedRice("大米、水");

        System.out.println("-------------------------------");
        jiuYangRiceCooker.porridge("大米，大量的水");
    }
}
