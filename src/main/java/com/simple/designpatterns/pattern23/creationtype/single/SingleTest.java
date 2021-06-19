package com.simple.designpatterns.pattern23.creationtype.single;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-19 12:11
 **/
public class SingleTest {
    public static void main(String[] args) {
        DoubleCheckSingleton t1 = DoubleCheckSingleton.getInstance("t1");
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    t1.name = "tttt1";
                    System.out.println(t1.name);
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    t1.name = "ttt2222";
                    System.out.println(t1.name);
                }
            }).start();
        }
        System.out.println("zuiwai:========" + t1.name);
    }
}
