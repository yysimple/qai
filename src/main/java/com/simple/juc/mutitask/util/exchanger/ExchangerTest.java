package com.simple.juc.mutitask.util.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-10 10:45
 **/
public class ExchangerTest {

//    private static Exchanger<String> exchanger = new Exchanger<>();
    private static MyExchanger<String> exchanger = new MyExchanger<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": 发起交易");
            try {
                // 阻塞，等待对方也发起交易
                exchanger.exchange("wait");
            } catch (InterruptedException e) {
                System.out.println(threadName + ": 发起交易失败");
                e.printStackTrace();
            }
            // 如果对方也同意交易，那么两者都会同时到达这里
            System.out.println(threadName + ": 对方同意，交易开始");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String exchange = "";
            try {
                System.out.println(threadName + ": 我需求就是卖一个皮肤给你，100w");
                exchange = exchanger.exchange("EZ未来战士", 30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println(threadName + ": 交易超时，已取消");
            }
            System.out.println(threadName + ": 交易成功，获得 " + exchange);
        }, "AAA-发起者").start();
        Thread.sleep(200);
        new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": 接收交易请求");
            try {
                exchanger.exchange("start");
            } catch (InterruptedException e) {
                System.out.println(threadName + ": 交易失败");
                e.printStackTrace();
            }
            System.out.println(threadName + ": 交易正式开始，说出你要卖的东西");
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String exchange = "";
            try {
                System.out.println(threadName + ": 皮肤收到，给你100w");
                exchange = exchanger.exchange("100w", 30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                System.out.println("交易失败");
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println(threadName + ": 交易超时，请再次发起");
                e.printStackTrace();
            }
            System.out.println(threadName + ": 交易成功，获得 " + exchange);
        }, "BBB-接收者").start();
    }
}
