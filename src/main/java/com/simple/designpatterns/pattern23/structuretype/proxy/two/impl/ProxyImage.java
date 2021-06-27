package com.simple.designpatterns.pattern23.structuretype.proxy.two.impl;

import com.simple.designpatterns.pattern23.structuretype.proxy.two.Image;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-27 14:57
 **/
public class ProxyImage implements Image {
    private RealImage realImage;

    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
