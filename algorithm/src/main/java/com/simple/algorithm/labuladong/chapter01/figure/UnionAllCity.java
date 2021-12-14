package com.simple.algorithm.labuladong.chapter01.figure;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 功能描述: 连通所有的城市
 *
 * @author: WuChengXing
 * @create: 2021-12-14 17:06
 **/
public class UnionAllCity {

    @Test
    public void test() {
        int[][] connections = new int[3][3];
        connections[0] = new int[]{1, 2, 5};
        connections[1] = new int[]{1, 3, 6};
        connections[2] = new int[]{2, 3, 1};
        int i = unionAllCity(3, connections);
        System.out.println("最后的最小权重：" + i);
    }

    public int unionAllCity(int n, int[][] connections) {
        // 因为城市编号是从1开始的，所以最后的 count 判断页会有所改变
        UFOne ufOne = new UFOne(n + 1);
        // 对所有边按照权重从小到大排序
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
        // 用于记录最小生成树的权重值
        int mst = 0;
        for (int[] connection : connections) {
            int c1 = connection[0];
            int c2 = connection[1];
            int weight = connection[2];
            // 如果两个城市是连接的，则不能加入 mst的计算，也就是要排除这个节点
            if (ufOne.connected(c1, c2)) {
                continue;
            }
            // 累加权重
            mst += weight;
            // 然后连接两个节点
            ufOne.union(c1, c2);
        }
        // 最后有个判断是否符合规则(这里的count是因为其从 1开始的)
        return ufOne.count() == 2 ? mst : -1;
    }
}
