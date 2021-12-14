package com.simple.algorithm.labuladong.chapter01.figure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-14 17:27
 **/
public class UnionNodeLowestCost {

    @Test
    public void test() {
        int[][] points = new int[5][2];
        points[0] = new int[]{0,0};
        points[1] = new int[]{2,2};
        points[2] = new int[]{3,10};
        points[3] = new int[]{5,2};
        points[4] = new int[]{7,0};
        System.out.println(minCostConnectPoints(points));
    }

    /**
     * 这里就是传入一系列的坐标
     * 成本的计算公式 |xi - xj| + |yi - yj|
     *
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        // 生成所有边及权重
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                // 用坐标点在 points 中的索引表示坐标点
                edges.add(new int[]{
                        i, j, Math.abs(xi - xj) + Math.abs(yi - yj)
                });
            }
        }
        // 将边按照权重从小到大排序
        Collections.sort(edges, Comparator.comparingInt(a -> a[2]));
        // 执行 Kruskal 算法
        int mst = 0;
        UFOne uf = new UFOne(length);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            // 若这条边会产生环，则不能加入 mst
            if (uf.connected(u, v)) {
                continue;
            }
            // 若这条边不会产生环，则属于最小生成树
            mst += weight;
            uf.union(u, v);
        }
        return mst;
    }
}
