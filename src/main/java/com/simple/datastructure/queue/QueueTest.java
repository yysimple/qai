package com.simple.datastructure.queue;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-04-28 20:50
 **/
public class QueueTest {
    public static void main(String[] args) {
        LinkedNode<Integer> linkedNode = new LinkedNode<>();
        linkedNode.push(1);
        linkedNode.push(2);
        System.out.println(linkedNode);
        linkedNode.poll();
        System.out.println(linkedNode);
    }
}
