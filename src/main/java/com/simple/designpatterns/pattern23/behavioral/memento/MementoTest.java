package com.simple.designpatterns.pattern23.behavioral.memento;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 备忘录模式
 *
 * 备忘录模式，其实就是将历史版本存放起来，便于之后去取出来进行回滚，其实数据库里面取最后一次操作日志是同一个道理，想拉链表也是如此设计，记录很多版本
 *
 * @author: WuChengXing
 * @create: 2021-07-03 10:49
 **/
public class MementoTest {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setOperation("操作 #1");
        originator.setVersion(1);
        careTaker.add(originator.save());
        // --------
        originator.setOperation("操作 #2");
        originator.setVersion(2);
        careTaker.add(originator.save());
        // ---------
        originator.setOperation("操作 #3");
        originator.setVersion(3);
        careTaker.add(originator.save());
        // ---------
        originator.setOperation("操作 #4");
        originator.setVersion(4);

        System.out.println("Current version: " + originator.getVersion() + ", operation：" + originator.getOperation());
        originator.getMemento(careTaker.get(0));
        System.out.println("First saved version: " + originator.getVersion() + ", operation：" + originator.getOperation());
        originator.getMemento(careTaker.get(1));
        System.out.println("Second saved version: " + originator.getVersion() + ", operation：" + originator.getOperation());
    }
}
