package com.simple.juc.mutitask.util.phaser;

import java.util.concurrent.Phaser;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-10 15:10
 **/
public class PhaserTest {
    public static void main(String[] args) {
        /**
         * arrive：到达屏障处，记录已经 arrive 的数量 +1，然后不阻塞继续往下跑。
         *
         * getPhase 和 arrive 的返回值有一定的联系：
         *
         * getPhase 返回当前处于第几段；
         *
         * arrive 返回当前到达的是第几段的屏障。
         *
         * getPhase - arrive 可能有两个值：
         *   0：arrive 之后，由于 arrive 的数量不足，还不能越过屏障；
         *   1：当前就是最后一个 arrive ，arrive 之后就越过屏障了，phase 就会进入下一个阶段，于是比 arrive 值大 1；
         *
         */
        Phaser p = new Phaser();
    }
}
