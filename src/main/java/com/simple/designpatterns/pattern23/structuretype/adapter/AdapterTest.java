package com.simple.designpatterns.pattern23.structuretype.adapter;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 适配器
 *
 * @author: WuChengXing
 * @create: 2021-06-19 14:15
 **/
public class AdapterTest {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "test.mp3");
        audioPlayer.play("mp4", "test.mp4");
        audioPlayer.play("vlc", "test.vlc");
    }
}
