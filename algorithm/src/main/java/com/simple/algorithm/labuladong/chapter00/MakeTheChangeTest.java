package com.simple.algorithm.labuladong.chapter00;

import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author WuChengXing
 * @date 2021/10/12
 */
public class MakeTheChangeTest extends BaseTest {

    /**
     * 先看下题目：给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，
     * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
     */

    @Test
    public void testMakeTheChange() {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(testMakeTheChangeDpTable(coins, 13));
    }

    /**
     * 递归方式
     *
     * @param coins
     * @param amount
     */
    public int testMakeTheChangeRecursion(int[] coins, int amount) {
        return makeTheChangeRecursion(coins, amount);
    }

    /**
     * 递归方式：碰到递归方式最好的办法，把所有的子情况都列出来，这里的问题是使用硬币组合成最终值，也就是 11 = xxx + xxx + xxx 就比如，举个例子
     * 假设amount = 11， 硬币面值是：1 2 5 那么就有这些情况：
     * 1. 第一次递归，11 - 1 = 10 / 11 - 2 = 9 / 11 - 5 = 6
     * 2. 第二次递归：这里只拿一个 子问题来说，10， 10 - 1 = 9 / 10 - 2 = 8 / 10 - 5 = 5
     * <p>
     * 这里两次情况就够了，然后之后就是一直递归，想 10 - 5 = 5 这种情况已经有答案了
     * 这里有个小问题，就是分成子问题之后，比如现在 10 - 5已经有答案了，但是是用三个硬币组成的，所以 这里在 res = Math.min(res, subProblem + 1);
     * 子问题是需要 +1 的，类似于 斐波那契
     * <p>
     * 时间：
     * ===== test start ========
     * 4
     * ===== test end ========
     * test millis time: ==> 1
     * test nano time: ==> 1662000
     *
     * @param coins
     * @param amount
     * @return
     */
    public int makeTheChangeRecursion(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 这里就是求出子问题
            int subProblem = makeTheChangeRecursion(coins, amount - coin);
            // 子问题为 -1 证明 此递归分支结束，继续执行下一个分支
            if (subProblem == -1) {
                continue;
            }
            // 子问题是需要 +1 的，类似于 斐波那契，看上面注释
            res = Math.min(res, subProblem + 1);
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    /**
     * 备忘录
     */
    int[] memo;

    /**
     * 备忘录方式：这里就是把每次 子问题 的计算结果放在备忘录里面，不需要对多个子问题去多次递归了
     * <p>
     * 计算时间：
     * ===== test start ========
     * 4
     * ===== test end ========
     * test millis time: ==> 1
     * test nano time: ==> 1579200
     *
     * @param coins
     * @param amount
     * @return
     */
    public int testMakeTheChangeMemo(int[] coins, int amount) {
        // 初始化长度为 amount + 1 就行，就是 coin都是 1 的情况
        memo = new int[amount + 1];
        // 初始值都给个 -666
        Arrays.fill(memo, -666);
        return makeTheChangeMemo(coins, amount);
    }

    public int makeTheChangeMemo(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        // 如果备忘录里面存入了值，直接从备忘录里面取出既可
        if (memo[amount] != -666) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 这里就是求出子问题
            int subProblem = makeTheChangeMemo(coins, amount - coin);
            // 子问题为 -1 证明 此递归分支结束，继续执行下一个分支
            if (subProblem == -1) {
                continue;
            }
            // 子问题是需要 +1 的，类似于 斐波那契，看上面注释
            res = Math.min(res, subProblem + 1);
        }
        // 把每次计算的结果都放入备忘录中
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

    /**
     * dp 数组的迭代解法：
     * dpTable 数组的定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出。
     * 其实这里就是
     * <p>
     * 时间计算：
     * ===== test start ========
     * 4
     * ===== test end ========
     * test millis time: ==> 1
     * test nano time: ==> 1386000
     *
     * @param coins
     * @param amount
     * @return
     */
    public int testMakeTheChangeDpTable(int[] coins, int amount) {
        // 数组长度这样定义跟上面一样
        int[] dpTable = new int[amount + 1];
        // 这里填充的话就是总金额大于1就行
        Arrays.fill(dpTable, amount + 1);

        // 判断0的情况
        dpTable[0] = 0;
        // 这里的索引就相当于列出 amount 的所有情况 0,1,2 ... amount，然后最终通过 比如 5块钱，的最少组成个数，自底向上的方式
        // 这个 i 相当于拆分成每个子问题，其实也是穷举，所有金额的可能性
        for (int i = 0; i < dpTable.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                // 求当前金额下的最少硬币数量，其实最终也是为了得到最终结果，这个就是 1 + min(dpTable[10], dpTable[9]...) 求出最小值
                dpTable[i] = Math.min(dpTable[i], 1 + dpTable[i - coin]);
            }
        }
        return dpTable[amount] == amount + 1 ? -1 : dpTable[amount];
    }


}
