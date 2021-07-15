package com.simple.designpatterns.pattern23.structuretype.decorator.two;

import com.simple.designpatterns.pattern23.structuretype.decorator.two.impl.Locomotive;
import com.simple.designpatterns.pattern23.structuretype.decorator.two.impl.SpeakerDecorator;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 测试类
 *
 * @author: WuChengXing
 * @create: 2021-07-09 23:37
 **/
public class DecoratorTest {
    public static void main(String[] args) {
        // 最原始的机车
        Car locomotive = new Locomotive();
        // 装上了音乐的机车
        SpeakerDecorator speakerDecorator = new SpeakerDecorator(locomotive);
        System.out.println("----- 最原始的机车 -----");
        locomotive.drive();
        System.out.println("----- 装上了音乐的机车 -----");
        speakerDecorator.drive();
        System.out.println("----- 单纯想听点音乐 -----");
        speakerDecorator.play();
    }
}
