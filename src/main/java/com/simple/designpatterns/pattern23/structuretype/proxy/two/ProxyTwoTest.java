package com.simple.designpatterns.pattern23.structuretype.proxy.two;

import com.simple.designpatterns.pattern23.structuretype.proxy.two.impl.ProxyImage;
import com.simple.designpatterns.pattern23.structuretype.proxy.two.impl.RealImage;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-27 14:59
 **/
public class ProxyTwoTest {
    public static void main(String[] args) {
        ProxyImage proxyImage01 = new ProxyImage("f.img");
        proxyImage01.display();
        System.out.println("---");
        ProxyImage proxyImage02 = new ProxyImage("f.img");
        proxyImage02.display();

        System.out.println("-----------");

        RealImage realImage = new RealImage("RealImage.img");
        realImage.display();
        System.out.println("---");
        realImage.display();
    }
}
