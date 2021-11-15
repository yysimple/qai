package com.simple.algorithm.labuladong.chapter01.figure;

import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-15 22:24
 **/
public class AllPathTest extends BaseTest {

    List<List<Integer>> res = new LinkedList<>();

    @Test
    public void test() {
        int[][] graph = new int[4][2];
        graph[0] = new int[]{1, 2};
        graph[1] = new int[]{3};
        graph[2] = new int[]{3};
        graph[3] = new int[]{};
        System.out.println(graph);
        List<List<Integer>> lists = allPath(graph);
        System.out.println("最后结果：" + lists);
    }

    public List<List<Integer>> allPath(int[][] graph) {
        // 这里用来记录最后的每一条路径
        List<Integer> path = new LinkedList<>();
        // 这个 0 是从root节点遍历的，也是邻接表的第一个元素
        traverse(graph, 0, path);
        return res;
    }

    public void traverse(int[][] graph, int s, List<Integer> path) {
        // 遍历进来添加到路径中
        path.add(s);
        // 有向图的路径最大长度
        int length = graph.length;
        // 到达了终点
        if (s == length - 1) {
            res.add(new LinkedList<>(path));
            // 回撤
            path.remove(path.size() - 1);
            return;
        }

        // 遍历图对应的 root的每个节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }
        // 回退节点
        path.remove(path.size() - 1);
    }
}
