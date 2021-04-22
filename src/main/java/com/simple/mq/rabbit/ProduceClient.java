package com.simple.mq.rabbit;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: 生产者测试
 *
 * @author: WuChengXing
 * @create: 2021-04-22 23:56
 **/
public class ProduceClient {
    public static void main(String[] args) throws Exception {
        MqClient.produce("SEND:Hello World");
    }
}
