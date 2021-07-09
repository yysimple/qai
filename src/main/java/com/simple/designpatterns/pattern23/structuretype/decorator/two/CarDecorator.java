package com.simple.designpatterns.pattern23.structuretype.decorator.two;

import com.simple.designpatterns.pattern23.structuretype.decorator.two.Car;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 装饰器，理解为可以给机车装上或者小毛驴装饰一些东西
 *
 * @author: WuChengXing
 * @create: 2021-07-09 23:43
 **/
public abstract class CarDecorator implements Car{
    private Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void drive() {
        car.drive();
    }
}
