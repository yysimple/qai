package com.simple.designpatterns.pattern23.structuretype.adapter;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 真正的视频播放器
 *
 * @author: WuChengXing
 * @create: 2021-06-20 13:00
 **/
public class Mp3AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        //播放 mp3 音乐文件的内置支持
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name: "+ fileName);
        }
        //mediaAdapter 提供了播放其他文件格式的支持
        else if(audioType.equalsIgnoreCase("avi")
                || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else{
            System.out.println("Invalid media. "+
                    audioType + " format not supported");
        }
    }
}
