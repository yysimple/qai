package com.simple.algorithm.array.stocks;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 暴力搜索
 *
 * @author: WuChengXing
 * @create: 2021-05-06 22:45
 **/
public class BruteForceSearch {
    /**
     * 最大收益
     */
    private int res;

    /**
     * 求最大收益
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        /**
         * 最小长度
         */
        int minLen = 2;
        if (len < minLen) {
            return 0;
        }
        this.res = 0;
        dfs(prices, 0, len, 0, res);
        return this.res;
    }

    /**
     * 描述：暴力搜索
     *
     * @param prices 股价数组
     * @param index  当前是第几天，从 0 开始
     * @param len    所有股票价格的长度，传入数组的长度
     * @param status 0 表示不持有股票，1表示持有股票
     * @param profit 当前收益
     */
    private void dfs(int[] prices, int index, int len, int status, int profit) {

        if (index == len) {
            this.res = Math.max(this.res, profit);
            return;
        }

        dfs(prices, index + 1, len, status, profit);

        if (status == 0) {
            // 可以尝试转向 1
            dfs(prices, index + 1, len, 1, profit - prices[index]);

        } else {
            // 此时 status == 1，可以尝试转向 0
            dfs(prices, index + 1, len, 0, profit + prices[index]);
        }
    }
}
