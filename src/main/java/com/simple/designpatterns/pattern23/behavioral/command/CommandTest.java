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
        ICuisine guangDongCuisine = new GuangDongCuisine(new GuangDongCook());
        ICuisine jiangXiCuisine = new JiangXiCuisine(new JiangXiCook());

        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.addCuisine(guangDongCuisine);
        xiaoEr.addCuisine(jiangXiCuisine);
        xiaoEr.placeOrder();
    }
}
