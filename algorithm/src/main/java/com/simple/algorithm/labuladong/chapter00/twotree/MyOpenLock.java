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
        int i = openLockTwoBFS(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
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

    /**
     * 双向队列通过bfs实现找到锁
     *
     * @param unLocks
     * @param lock
     * @return
     */
    public int openLockTwoBFS(String[] unLocks, String lock) {
        // 不能碰到的死锁情况
        Set<String> unLocksSet = new HashSet<>(Arrays.asList(unLocks));
        // 已经出现过一次穷举
        Set<String> alreadyLock = new HashSet<>();

        // 初始化扩散队列（这里就是两个队列，如果有交集就走完该种情况）
        Set<String> one = new HashSet<>();
        Set<String> two = new HashSet<>();
        one.add("0000");
        two.add(lock);
        int step = 0;
        while (!one.isEmpty() && !two.isEmpty()) {
            Set<String> tempSet = new HashSet<>();

            // 还是从开始的节点进行扩散
            for (String curr : one) {
                if (unLocksSet.contains(curr)) {
                    continue;
                }
                if (two.contains(curr)) {
                    return step;
                }
                alreadyLock.add(curr);

                for (int i = 0; i < 4; i++) {
                    String up = OpenLockTest.plusOne(curr, i);
                    if (!alreadyLock.contains(up)) {
                        tempSet.add(up);
                    }
                    String down = OpenLockTest.minusOne(curr, i);
                    if (!alreadyLock.contains(down)) {
                        tempSet.add(down);
                    }
                }
            }
            step++;
            one = two;
            two = tempSet;
        }
        return -1;
    }
}
