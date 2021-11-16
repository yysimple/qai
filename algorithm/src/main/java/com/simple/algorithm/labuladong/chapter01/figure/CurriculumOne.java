package com.simple.algorithm.labuladong.chapter01.figure;

import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-16 23:01
 **/
public class CurriculumOne extends BaseTest {

    boolean[] alreadyPath;
    boolean[] visited;
    boolean hasCycle = false;

    @Test
    public void test() {
        int curriculums = 2;
        int[][] prerequisites = new int[4][4];
        prerequisites[0] = new int[]{1, 0};
        prerequisites[1] = new int[]{0, 1};
        System.out.println(canFinish(curriculums, prerequisites));
    }

    public Boolean canFinish(int curriculums, int[][] prerequisites) {
        // 构建图
        List<Integer>[] graph = buildGraph(curriculums, prerequisites);
        // 记录遍历过的节点，防止走回头路
        visited = new boolean[curriculums];
        // 记录一次 traverse 递归经过的节点
        alreadyPath = new boolean[curriculums];
        for (int i = 0; i < curriculums; i++) {
            // 先从课程遍历，里层会去递归能够到达的路径
            traverse(graph, i);
        }
        return !hasCycle;
    }

    public void traverse(List<Integer>[] graph, int node) {
        // 已经在遍历路径上的节点，证明已经出现了，所以有环
        if (alreadyPath[node]) {
            hasCycle = true;
        }
        // 有环或者已经遍历了，则跳出循环
        if (visited[node] || hasCycle) {
            return;
        }
        visited[node] = true;
        alreadyPath[node] = true;
        for (Integer integer : graph[node]) {
            traverse(graph, integer);
        }
        // 回撤
        alreadyPath[node] = false;

    }

    public List<Integer>[] buildGraph(int curriculums, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[curriculums];
        for (int i = 0; i < curriculums; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }
}
