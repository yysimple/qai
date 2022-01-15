package com.simple.jvm.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述: 复现线上GC问题
 *
 * @author: WuChengXing
 * @create: 2022-01-15 16:25
 **/
public class JvmGcFind {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Ticket> ticketMap = new HashMap<>(1024);
        for (int i = 0; i < 10000; i++) {
            String scenicName = "景区" + i + "-" + "Latitude，longitude";
            Ticket build = Ticket.build("好好玩玩，景区生活是很舒服的" + i, "景区" + i, i % 10);
            ticketMap.put(scenicName, build);
            Thread.sleep(10);
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
