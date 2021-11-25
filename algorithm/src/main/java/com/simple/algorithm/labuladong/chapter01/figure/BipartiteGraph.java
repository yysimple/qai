package com.simple.algorithm.labuladong.chapter01.figure;

import org.junit.Test;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-25 22:29
 **/
public class BipartiteGraph {

    /**
     * 是否是二分图
     */
    boolean isOk = true;

    /**
     * 是否被访问过
     */
    boolean[] visited;

    /**
     * 上色
     */
    boolean[] color;

    @Test
    public void test() {
        int[][] ints = buildGraph();
        System.out.println(isBipartiteDFS(ints));
    }


    private boolean isBipartiteDFS(int[][] graph) {
        // 拿到图的大小，因为需要遍历所有的节点
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];
        // 遍历所有的节点
        for (int i = 0; i < n; i++) {
            // 如果之前没有访问过的去递归
            if (!visited[i]) {
                traverseDFS(graph, i);
            }
        }
        // 如果是二分图，则直接返回
        return isOk;
    }

    private void traverseDFS(int[][] graph, int node) {
        // 如果是二分图，直接返回
        if (!isOk) {
            return;
        }

        visited[node] = true;
        // 遍历图的该节点的相邻节点
        for (int i : graph[node]) {
            // 如果是已经遍历过了的，就判断颜色问题,这是没有遍历的情况
            if (!visited[i]) {
                // 将节点的颜色，赋值给相邻的节点，取得应该是相反的颜色
                // 如果不是二分图，这里就可能赋值成了 i 被其他节点又改成了node一样的颜色
                color[i] = !color[node];
                // 继续遍历i节点
                traverseDFS(graph, i);
            } else {
                if (color[node] == color[i]) {
                    // 如果相邻节点之间的元素颜色是一样的，则不是二分图
                    isOk = false;
                }
            }
        }
    }

    /**
     * 构件图
     *
     * @return
     */
    public int[][] buildGraph() {
        int[][] graph = new int[4][4];
        int[] node1 = new int[]{1, 3};
        int[] node2 = new int[]{0, 2};
        int[] node3 = new int[]{1, 3};
        int[] node4 = new int[]{0, 2};
        graph[0] = node1;
        graph[1] = node2;
        graph[2] = node3;
        graph[3] = node4;
        return graph;
    }
}
