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
     * 大致分为4种情况
     * 情况1：cand认识other，所以cand肯定不是名人，排除。因为名人不可能认识别人。
     * 情况2：other认识cand，所以other肯定不是名人，排除。
     * 情况3：他俩互相认识，肯定都不是名人，可以随便排除一个。
     * 情况4：他俩互不认识，肯定都不是名人，可以随便排除一个。因为名人应该被所有其他人认识。
     *
     * @param n
     * @return
     */
    public int findCelebrity2(int n) {
        // 假设名人是cand
        int cand = 0;
        // 这里可以跳过自己跟自己比较，没有必要
        for (int other = 1; other < n; other++) {
            // 如果 其他人 不认识 候选人，候选人认识其他人，这个时候就排除 cand，取other
            if (!knows(other, cand) || knows(cand, other)) {
                cand = other;
            }
        }
        for (int other = 0; other < n; other++) {
            // 如果other和cand相等，就不比较了
            if (other == cand) {
                continue;
            }
            // 如果其他人不认识cand，cand认识其他人，那cand就不是名人
            if (!knows(other, cand) || knows(cand, other)) {
                return -1;
            }
        }
        return cand;
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
