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
        System.out.println(testFibonacciRecursion(2));
    }

    /**
     * 这种就是常规的递归，会存在很多子问题，比如 f(18)就会计算两次；
     * 递归算法的时间复杂度怎么计算？就是用子问题个数乘以解决一个子问题需要的时间
     * 所以这里就是 O(2^n) * O(1) 指数级增长
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

    public int testFibonacciMemo(int n) {
        return 0;
    }
}
