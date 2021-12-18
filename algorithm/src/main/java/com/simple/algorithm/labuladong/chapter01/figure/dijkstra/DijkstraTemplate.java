package com.simple.algorithm.labuladong.chapter01.figure.dijkstra;

import lombok.Data;

import java.util.*;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-16 23:39
 **/
public class DijkstraTemplate {

    // 返回节点 from 到节点 to 之间的边的权重
    int weight(int from, int to) {
        return 1;
    }

    // 输入节点 s 返回 s 的相邻节点
    List<Integer> adj(int s) {
        return null;
    }

    /**
     * 输入一幅图和一个起点 start，计算 start 到其他节点的最短距离
     *
     * @param start
     * @param graph
     * @return
     */
    int[] dijkstra(int start, List<Integer>[] graph) {
        // 首先拿到图的长度
        int length = graph.length;
        // 初始化可能出现的最短路径
        int[] distTo = new int[length];
        // 填充每个位置为最大值
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // 初始化 start 处 为0
        distTo[start] = 0;
        // 优先级队列，distFromStart 较小的排在前面
        Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s.distFromStart));
        // 将开始节点放入到队列中
        queue.offer(new State(start, 0));
        // 开始遍历，找到最短路径
        while (!queue.isEmpty()) {
            State poll = queue.poll();
            int currentNodeId = poll.getId();
            int curDistFromStart = poll.getDistFromStart();
            // 如果当前距离大于已经存在的可能最短路径，证明已经有一条更短的路径到达 curNode 节点了
            if (curDistFromStart > distTo[currentNodeId]) {
                continue;
            }
            // 找相邻的节点进行比较
            for (Integer nextNodeId : adj(currentNodeId)) {
                // 先拿到当前节点再到下一个节点的距离
                int nextDistFromStart = curDistFromStart + weight(currentNodeId, nextNodeId);
                // 如果比已存在的更小，则加入到可能最短距离的数组中，覆盖原来的值
                if (nextDistFromStart < distTo[nextNodeId]) {
                    distTo[nextNodeId] = nextDistFromStart;
                    // 继续往下走
                    queue.offer(new State(nextNodeId, nextDistFromStart));
                }
            }
        }
        return distTo;
    }
}


