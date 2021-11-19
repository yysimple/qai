package com.simple.jvm.classparsing.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2021/11/19
 * <p>
 * 参数设置：
 * -Xmx500M -Xms500M -Xmn200M -XX:+UseConcMarkSweepGC
 * -XX:+UseCMSInitiatingOccupancyOnly  -XX:CMSInitiatingOccupancyFraction=90
 */
public class ByteArrayGc {
    public static void main(String[] args) {
        allocateMemory();
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void allocateMemory() {
        List<byte[]> list = new ArrayList<>();
        int size = 1024 * 1024 * 480;
        int len = size / (20 * 1024);
        for (int i = 0; i < len; i++) {
            try {
                byte[] bytes = new byte[20 * 1024];
                list.add(bytes);
            } catch (OutOfMemoryError error) {

            }
        }
    }
}
