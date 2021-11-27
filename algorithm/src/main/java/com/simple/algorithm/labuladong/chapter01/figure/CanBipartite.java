package com.simple.algorithm.labuladong.chapter01.figure;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-27 09:50
 **/
public class CanBipartite {

    boolean isOk = true;
    boolean[] visited;
    boolean[] color;

    @Test
    public void test() {
        System.out.println(possibleBipartition(4, buildDislikes1()));
        System.out.println(possibleBipartition(3, buildDislikes2()));
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 初始化两个标记数组
        color = new boolean[n + 1];
        visited = new boolean[n + 1];
        // 构建图
        List<Integer>[] lists = buildGraph(n, dislikes);
        // 遍历图,排除自己跟自己比较，所以可以排除00
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                traverse(lists, i);
            }
        }
        return isOk;
    }

    /**
     * 递归调用
     *
     * @param graph
     */
    public void traverse(List<Integer>[] graph, int node) {
        if (!isOk) {
            return;
        }
        // 表示访问过了，不在访问
        visited[node] = true;
        for (Integer integer : graph[node]) {
            if (!visited[integer]) {
                color[integer] = !color[node];
                traverse(graph, integer);
            } else {
                if (color[integer] == color[node]) {
                    isOk = false;
                }
            }
        }
    }

    /**
     * 构建图的操作
     *
     * @param n
     * @param dislikes
     * @return
     */
    public List<Integer>[] buildGraph(int n, int[][] dislikes) {
        // 图节点编号为 1...n
        List<Integer>[] graph = new LinkedList[n + 1];
        // 初始化
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] dislike : dislikes) {
            // 取出互相讨厌的两个人
            int a = dislike[1];
            int b = dislike[0];
            // 构建有向图，表示互相讨厌的关系
            graph[a].add(b);
            graph[b].add(a);
        }
        return graph;
    }

    public int[][] buildDislikes1() {
        int[][] dislikes = new int[3][2];
        int[] node1 = new int[]{1, 2};
        int[] node2 = new int[]{1, 3};
        int[] node3 = new int[]{2, 4};
        dislikes[0] = node1;
        dislikes[1] = node2;
        dislikes[2] = node3;
        return dislikes;
    }

    public int[][] buildDislikes2() {
        int[][] dislikes = new int[3][2];
        int[] node1 = new int[]{1, 2};
        int[] node2 = new int[]{1, 3};
        int[] node3 = new int[]{2, 3};
        dislikes[0] = node1;
        dislikes[1] = node2;
        dislikes[2] = node3;
        return dislikes;
    }

}
