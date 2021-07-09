package com.simple.designpatterns.pattern23.structuretype.adapter.impl;

import com.simple.designpatterns.pattern23.structuretype.adapter.AdvancedMediaPlayer;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-20 12:56
 **/
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playAvi(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
