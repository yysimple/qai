package com.simple.algorithm.labuladong.chapter00;

import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

/**
 * @author WuChengXing
 * @date 2021/10/8
 */
public class FibonacciTest extends BaseTest {

    @Test
    public void run() {
        System.out.println(testFibonacciDpCompression(20));
    }

    /**
     * 这种就是常规的递归，会存在很多子问题，比如 f(18)就会计算两次；
     * 递归算法的时间复杂度怎么计算？就是用子问题个数乘以解决一个子问题需要的时间
     * 所以这里就是 O(2^n) * O(1) 指数级增长
     * <p>
     * 计算时间：
     * test millis time: ==> 2
     * test nano time: ==> 1697500
     *
     * @param n
     * @return
     */
    public int testFibonacciRecursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return testFibonacciRecursion(n - 1) + testFibonacciRecursion(n - 2);
    }

    /**
     * 这种方式是使用备忘录模式，因为之前说的会存在 f(18) 被计算两次，而其他的如 f(2) 之类的则是 2的指数级别
     * 所以这里每次记录计算结果 比如 n = 20 的时候 f(20) = f(19) + f(18)；此时的 f(18) 会记录在memo中
     * 然后当 n = 18 的时候 f(18) 直接从memo中取出就行
     * 这样就成了 自顶向下 的求解方式，就消除了子重叠问题
     * <p>
     * 计算时间：
     * test millis time: ==> 1
     * test nano time: ==> 1448700
     *
     * @param n
     * @return
     */
    public int testFibonacciMemo(int n) {
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }

    public int helper(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * 这种是动态规划思路，采用的是 自底向上 的思路，拆分成小问题
     * 这里其实就是 哪一个定长的数组去记录每次计算方程的值，比如：
     * - 数组1号索引：f(1)
     * - 数组2号索引：f(2)
     * - 数组3号索引：f(3) = f(2) + f(1) = 2
     * - 数组4号索引：f(4) = f(3) + f(2) = 3
     * <p>
     * 一次类推，就可以在n号索引位置上求到想要的值
     * <p>
     * 计算时间：
     * test millis time: ==> 1
     * test nano time: ==> 1468200
     *
     * @param n
     * @return
     */
    public int testFibonacciDp(int n) {
        int[] dpTable = new int[n + 1];
        dpTable[0] = 0;
        dpTable[1] = 1;
        for (int i = 2; i <= n; i++) {
            dpTable[i] = dpTable[i - 1] + dpTable[i - 2];
        }
        return dpTable[n];
    }


    /**
     * 在上一个dp过程中，我们可以发现：
     * 根据斐波那契数列的状态转移方程，当前状态只和之前的两个状态有关，
     * 其实并不需要那么长的一个 DP table 来存储所有的状态，只要想办法存储之前的两个状态就行了。
     * 所以，可以进一步优化，把空间复杂度降为 O(1)
     * <p>
     * 计算时间：
     * test millis time: ==> 2
     * test nano time: ==> 1479700
     *
     * @param n
     * @return
     */
    public int testFibonacciDpCompression(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int curr = 1, prev = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
