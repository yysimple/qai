package com.simple.algorithm.labuladong.chapter00.twotree;

import org.junit.Test;

import java.util.*;

/**
 * @author WuChengXing
 * @date 2021/10/15
 */
public class MyOpenLock {

    @Test
    public void testMyOpenLock() {
        int i = openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(i);
    }

    public int openLock(String[] unLocks, String lock) {
        // 不能碰到的死锁情况
        Set<String> unLocksSet = new HashSet<>(Arrays.asList(unLocks));
        // 已经出现过一次穷举
        Set<String> alreadyLock = new HashSet<>();

        // 初始化扩散队列
        Queue<String> currLocks = new LinkedList<>();
        // 初始化
        int step = 0;
        alreadyLock.add("0000");
        currLocks.offer("0000");

        // 扩散队列为空的情况下找到最终结果
        while (!currLocks.isEmpty()) {
            // 扩散的大小
            int size = currLocks.size();
            for (int i = 0; i < size; i++) {
                String curr = currLocks.poll();
                // 结束条件
                if (unLocksSet.contains(curr)) {
                    continue;
                }
                if (curr.equals(lock)) {
                    return step;
                }

                // 每次选择有上下两种情况，所以遍历字符即可
                for (int j = 0; j < 4; j++) {
                    String up = OpenLockTest.plusOne(curr, j);
                    if (!alreadyLock.contains(up)) {
                        currLocks.offer(up);
                        alreadyLock.add(up);
                    }
                    String down = OpenLockTest.minusOne(curr, j);
                    if (!alreadyLock.contains(down)) {
                        currLocks.offer(down);
                        alreadyLock.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
