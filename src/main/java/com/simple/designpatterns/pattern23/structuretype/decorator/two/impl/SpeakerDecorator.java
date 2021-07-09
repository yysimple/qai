package com.simple.designpatterns.pattern23.structuretype.decorator.two.impl;

import com.simple.designpatterns.pattern23.structuretype.decorator.two.Car;
import com.simple.designpatterns.pattern23.structuretype.decorator.two.CarDecorator;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 音箱
 *
 * @author: WuChengXing
 * @create: 2021-07-09 23:47
 **/
public class SpeakerDecorator extends CarDecorator {
    public SpeakerDecorator(Car car) {
        super(car);
    }

    @Override
    public void drive() {
        super.drive();
        play();
    }

    public void play(){
        System.out.println("=== 来点音乐助助兴 ===");
    }
}
