package com.simple.mq.rabbit;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: 消费者测试
 *
 * @author: WuChengXing
 * @create: 2021-04-22 23:56
 **/
public class ConsumeClient {
    public static void main(String[] args) throws Exception {
        String message = MqClient.consume();

        System.out.println("获取的消息为：" + message);
    }
}
