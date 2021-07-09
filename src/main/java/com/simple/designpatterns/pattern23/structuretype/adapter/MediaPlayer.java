package com.simple.designpatterns.pattern23.structuretype.adapter;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 媒体播放器
 *
 * @author: WuChengXing
 * @create: 2021-06-20 12:52
 **/
public interface MediaPlayer {
    /**
     * 播放功能
     *
     * @param audioType
     * @param fileName
     */
    void play(String audioType, String fileName);
}
