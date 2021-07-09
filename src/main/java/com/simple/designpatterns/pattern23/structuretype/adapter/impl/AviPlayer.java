package com.simple.designpatterns.pattern23.structuretype.adapter.impl;

import com.simple.designpatterns.pattern23.structuretype.adapter.AdvancedMediaPlayer;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-20 12:55
 **/
public class AviPlayer implements AdvancedMediaPlayer {
    @Override
    public void playAvi(String fileName) {
        System.out.println("Playing avi file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
