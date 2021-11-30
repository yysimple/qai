package com.simple.algorithm.labuladong.chapter01.figure;

import org.junit.Test;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-30 22:27
 **/
public class UFApplication {

    @Test
    public void test() {
        String[] s1 = new String[]{"a==b", "b!=c", "c==a"};
        String[] s2 = new String[]{"c==c", "b==d", "x!=z"};
        System.out.println(equationsPossible(s1));
        System.out.println(equationsPossible(s2));
    }

    public boolean equationsPossible(String[] equations) {
        UFOne ufOne = new UFOne(26);
        // 先让相等的字母形成连通分量
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                ufOne.union(x - 'a', y - 'a');
            }
        }

        // 检查不等关系是否打破相等关系的连通性
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                // 如果相等关系成立，就是逻辑冲突
                if (ufOne.connected(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }
        return true;

    }
}
