package com.simple.designpatterns.pattern23.structuretype.proxy.two.impl;

import com.simple.designpatterns.pattern23.structuretype.proxy.two.Image;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-27 14:50
 **/
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("displaying ... " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("loading ... " + fileName);
    }
}
