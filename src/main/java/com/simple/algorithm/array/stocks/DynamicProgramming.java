package com.simple.algorithm.array.stocks;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 动态规划
 *
 * @author: WuChengXing
 * @create: 2021-05-06 22:47
 **/
public class DynamicProgramming {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len][2];

        // 第一天、持有现金操作
        dp[0][0] = 0;
        // 第一天买入操作，持有股票的情况
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
