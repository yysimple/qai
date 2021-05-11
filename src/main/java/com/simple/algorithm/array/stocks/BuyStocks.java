package com.simple.algorithm.array.stocks;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述: 买卖股票算法
 *
 * @author: WuChengXing
 * @create: 2021-05-05 09:20
 **/
public class BuyStocks {

    public static void main(String[] args) {
        /**
         * 暴力搜索
         */
        BruteForceSearch buyStocks = new BruteForceSearch();
        int[] prices = new int[]{1, 6, 2, 9};
        System.out.println(buyStocks.maxProfit(prices));
    }

}
