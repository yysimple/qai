package com.simple.mq.rabbit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: 消息的客户端（对外提供的api一样）
 *
 * @author: WuChengXing
 * @create: 2021-04-22 23:54
 **/
public class MqClient {
    /**
     * 生产消息
     *
     * @param message
     * @throws Exception
     */
    public static void produce(String message) throws Exception {
        //本地的的BrokerServer.SERVICE_PORT 创建SOCKET
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ) {
            out.println(message);
            out.flush();
        }
    }

    /**
     * 消费消息
     *
     * @return
     * @throws Exception
     */
    public static String consume() throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ) {
            //先向消息队列发送命令
            out.println("CONSUME");
            out.flush();

            //再从消息队列获取一条消息
            String message = in.readLine();

            return message;
        }
    }
}
