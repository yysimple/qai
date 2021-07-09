package com.simple.designpatterns.pattern23.structuretype.adapter;

import com.simple.designpatterns.pattern23.structuretype.adapter.impl.Mp4Player;
import com.simple.designpatterns.pattern23.structuretype.adapter.impl.AviPlayer;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 多功能媒体适配器，相当于将高级媒体播放器的功能放到适配器中，
 * 当之前老的播放器想要播放其他媒体文件时，插上适配器就行了
 *
 * @author: WuChengXing
 * @create: 2021-06-20 12:57
 **/
public class MediaAdapter implements MediaPlayer {
    /**
     * 高级媒体播放器，啥玩意都能播放
     */
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("avi")) {
            advancedMediaPlayer = new AviPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    /**
     * 通过适配器来播放不同文件的音频或视屏
     * @param audioType
     * @param fileName
     */
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("avi")) {
            advancedMediaPlayer.playAvi(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
