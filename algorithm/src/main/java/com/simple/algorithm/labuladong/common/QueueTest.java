package com.simple.algorithm.labuladong.common;

import com.simple.algorithm.labuladong.chapter00.twotree.init.TreeNodeInit;
import com.simple.algorithm.labuladong.common.model.TreeNode;
import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuChengXing
 * @date 2021/10/15
 */
public class QueueTest extends BaseTest {

    /**
     * add方法，在不违背队列的容量限制的情况，往队列中添加一个元素， 如果添加成功则返回true,  如果因为容量
     * * 限制添加失败了，则抛出IllegalStateException异常
     * *
     * *  在有容量限制的队列中，最好使用offer方法
     * *  另外，add方法相对与offer方法而言，有一个专门抛出的异常IllegalStateException，代表由于容量限制，
     * * 导致不能添加元素的异常，接口中可能看不出，等看具体实现就明白了
     */
    @Test
    public void testQueueAdd() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue);
    }

    /**
     * offer方法在不违背容量限制的情况，往队列中添加一个元素，如果添加元素成功，返回true，
     * *  如果因为空间限制，无法添加元素则，返回false；
     * *
     * *  在有容量限制的队列中，这个offer方法优于add方法，结合上文中add的注释，可知，
     * *  在容量限制的队列中， add方法通过抛异常的方式表示容量已满，offer方法通过返回
     * *  false的方式表示容量已满，抛异常处理更加耗时，offer直接返回false的方式更好
     */
    @Test
    public void testQueueOffer() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.offer(3);
        System.out.println(queue);
    }

    @Test
    public void testQueueSize() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(TreeNodeInit.init1());
        System.out.println(queue.size());
    }
}
