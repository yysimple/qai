package com.simple.designpatterns.pattern23.structuretype.adapter;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 多功能播放器
 *
 * @author: WuChengXing
 * @create: 2021-06-20 12:54
 **/
public interface AdvancedMediaPlayer {
    void playAvi(String fileName);

    void playMp4(String fileName);
}
