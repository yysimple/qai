package com.simple.designpatterns.pattern23.behavioral.command;

import com.simple.designpatterns.pattern23.behavioral.command.impl.GuangDongCook;
import com.simple.designpatterns.pattern23.behavioral.command.impl.GuangDongCuisine;
import com.simple.designpatterns.pattern23.behavioral.command.impl.JiangXiCook;
import com.simple.designpatterns.pattern23.behavioral.command.impl.JiangXiCuisine;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-28 22:43
 **/
public class CommandTest {
    public static void main(String[] args) {
        /**
         * 可以理解为guangDongCuisine、jiangXiCuisine 这两东西就是两条指令
         */
        ICuisine guangDongCuisine = new GuangDongCuisine(new GuangDongCook());
        ICuisine jiangXiCuisine = new JiangXiCuisine(new JiangXiCook());

        XiaoEr xiaoEr = new XiaoEr();
        /**
         * 这里理解为是一个批处理脚本，相当于 linux中的 sh文件
         */
        xiaoEr.addCuisine(guangDongCuisine);
        xiaoEr.addCuisine(jiangXiCuisine);
        /**
         * 这里就是命令执行，可以将其等价为 ./xxx.sh,然后就会去执行相应的可执行脚本，就会去执行那些命令
         */
        xiaoEr.placeOrder();
    }
}
