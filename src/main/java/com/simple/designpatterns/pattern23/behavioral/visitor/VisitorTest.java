package com.simple.designpatterns.pattern23.behavioral.visitor;

import com.simple.designpatterns.pattern23.behavioral.visitor.impl.Parent;
import com.simple.designpatterns.pattern23.behavioral.visitor.impl.Principal;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 访问者模式
 *
 * @author: WuChengXing
 * @create: 2021-07-05 23:04
 **/
public class VisitorTest {
    public static void main(String[] args) {
        DataView dataView = new DataView();
        System.out.println("====== 校长 =======");
        dataView.show(new Principal());
        System.out.println("====== 家长 =======");
        dataView.show(new Parent());
    }
}
