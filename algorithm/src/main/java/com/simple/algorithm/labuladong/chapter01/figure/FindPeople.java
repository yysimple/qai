package com.simple.algorithm.labuladong.chapter01.figure;

import org.junit.Test;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-24 00:09
 **/
public class FindPeople {

    @Test
    public void test() {

    }

    /**
     * 暴力解题
     *
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        for (int cand = 0; cand < n; cand++) {
            int other;
            for (other = 0; other < n; other++) {
                if (cand == other) {
                    continue;
                }
                // 这里意思就是，我不认识其他人，其他人都认识我
                if (knows(cand, other) || !knows(other, cand)) {
                    break;
                }
            }
            // 保证每个人之间都进行了比较，比较完了之后，就返回cand
            if (other == n) {
                return cand;
            }
        }
        return -1;
    }

    /**
     * 可以直接调用，能够返回 i 是否认识 j
     * 这里的方法不去实现
     *
     * @param i
     * @param j
     * @return
     */
    boolean knows(int i, int j) {
        if (true) {
            return true;
        }
        return false;
    }

}
