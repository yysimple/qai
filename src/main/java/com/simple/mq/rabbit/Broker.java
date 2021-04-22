package com.simple.mq.rabbit;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: blocker 消息处理中心
 * <p>
 * <p>
 * 生产消息：客户端执行生产消息方法，传入需要生产的信息，该信息需要遵循我们自定义的协议，
 * 消息处理中心服务在接受到消息会根据自定义的协议校验该消息是否合法，
 * 如果合法如果合法就会将该消息存储到Broker内部维护的 ArrayBlockingQueue 队列中．
 * 如果 ArrayBlockingQueue 队列没有达到我们协议中的最大长度将将消息添加到队列中，否则输出生产消息失败．
 * 消息消息：客户端执行消费消息方法，
 * Broker服务 会校验请求的信息的信息是否等于 CONSUME ，
 * 如果验证成功则从Broker内部维护的 ArrayBlockingQueue 队列的 Poll 出一个消息返回给客户端
 *
 * @author: WuChengXing
 * @create: 2021-04-22 23:43
 **/
public class Broker {
    /**
     * 队列存储消息的最大数量
     */
    private final static int MAX_SIZE = 3;

    /**
     * 保存消息数据的容器
     */
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(MAX_SIZE);

    /**
     * 生产消息
     * tip：这里是消息投递的过程，放入到初始化的队列中
     *
     * @param msg
     */
    public static void produce(String msg) {
        if (messageQueue.offer(msg)) {
            System.out.println("成功向消息处理中心投递消息：" + msg + "，当前暂存的消息数量是：" + messageQueue.size());
        } else {
            System.out.println("消息处理中心内暂存的消息达到最大负荷，不能继续放入消息！");
        }
        System.out.println("=======================");
    }

    /**
     * 消费消息
     * tip： 从队列里将消息取出来
     *
     * @return
     */
    public static String consume() {
        String msg = messageQueue.poll();
        if (msg != null) {
            // 消费条件满足情况，从消息容器中取出一条消息
            System.out.println("已经消费消息：" + msg + "，当前暂存的消息数量是：" + messageQueue.size());
        } else {
            System.out.println("消息处理中心内没有消息可供消费！");
        }
        System.out.println("=======================");

        return msg;
    }
}
