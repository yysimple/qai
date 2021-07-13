package com.simple.designpatterns.pattern23.creationtype.prototype;

import com.simple.designpatterns.pattern23.creationtype.prototype.impl.StatisticImpl;


/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 原型模式
 *
 * @author: WuChengXing
 * @create: 2021-07-13 21:47
 **/
public class PrototypeTest {
    static Statistic statistic = new StatisticImpl();

    public static void main(String[] args) {
        totalToIndex();
        totalToReport();
        System.out.println("---- 其他查询 ----");
        statistic.totalOrder();
    }

    public static void totalToIndex() {
        System.out.println("---- 首页的查询 ----");
        statistic.totalOrder();
    }

    public static void totalToReport() {
        System.out.println("---- 报表页的查询 ----");
        statistic.totalOrder();
    }
}
