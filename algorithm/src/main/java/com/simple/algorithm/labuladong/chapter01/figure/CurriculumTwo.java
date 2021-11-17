package com.simple.algorithm.labuladong.chapter01.figure;

import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.util.*;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-17 20:37
 **/
public class CurriculumTwo extends BaseTest {

    // 记录后序遍历结果
    List<Integer> postorder = new ArrayList<>();
    // 判断是否有环
    boolean hasCycle = false;
    boolean[] visited, alreadyNode;

    @Test
    public void test() {
        int curriculum = 4;
        int[][] prerequisites = new int[4][2];
        prerequisites[0] = new int[]{1, 0};
        prerequisites[1] = new int[]{2, 0};
        prerequisites[2] = new int[]{3, 1};
        prerequisites[3] = new int[]{3, 2};
        int[] order = findOrder(curriculum, prerequisites);
        System.out.println(Arrays.toString(order));

    }

    public int[] findOrder(int curriculum, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(curriculum, prerequisites);
        visited = new boolean[curriculum];
        alreadyNode = new boolean[curriculum];
        // 遍历图
        for (int i = 0; i < curriculum; i++) {
            traverse(graph, i);
        }
        // 有环直接返回
        if (hasCycle) {
            return new int[]{};
        }
        // 将后序遍历反转一下就是最后的结果了
        Collections.reverse(postorder);
        int[] res = new int[curriculum];
        for (int i = 0; i < curriculum; i++) {
            res[i] = postorder.get(i);
        }
        return res;

    }

    public void traverse(List<Integer>[] graph, int node) {
        // 遍历的路径上为true，证明这个有环
        if (alreadyNode[node]) {
            hasCycle = true;
        }
        // 该节点已经遍历过了，或者有环，直接跳出
        if (visited[node] || hasCycle) {
            return;
        }
        // 前序遍历位置
        alreadyNode[node] = true;
        visited[node] = true;
        for (Integer n : graph[node]) {
            traverse(graph, n);
        }
        // 添加后序遍历节点
        postorder.add(node);
        alreadyNode[node] = false;
    }

    public List<Integer>[] buildGraph(int curriculum, int[][] prerequisites) {
        // 图中共有 numCourses 个节点
        List<Integer>[] graph = new LinkedList[curriculum];
        for (int i = 0; i < curriculum; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            // 修完课程 from 才能修课程 to
            // 在图中添加一条从 from 指向 to 的有向边
            graph[from].add(to);
        }
        return graph;
    }
}
