package com.simple.algorithm.labuladong.chapter01.figure.dijkstra;

import org.junit.Test;

import java.util.*;

/**
 * 功能描述: 最小网络延迟
 *
 * @author: WuChengXing
 * @create: 2021-12-18 18:14
 **/
public class NetworkDelayaTime {

    @Test
    public void test() {
        int[][] times = new int[3][3];
        times[0] = new int[]{2, 1, 1};
        times[1] = new int[]{2, 3, 1};
        times[2] = new int[]{3, 4, 1};
        System.out.println(networkMinDelayaTime(times, 4, 2));
    }

    /**
     * 计算节点之间通信的最小时延
     *
     * @param times
     * @param nodeNum
     * @param start
     * @return
     */
    public int networkMinDelayaTime(int[][] times, int nodeNum, int start) {
        // 初始画图信息，这里节点是从1 开始的，所以数组长度 + 1
        List<int[]>[] graph = new LinkedList[nodeNum + 1];
        // 初始化每个节点
        for (int i = 1; i <= nodeNum; i++) {
            graph[i] = new LinkedList<>();
        }
        // 初始化数据
        for (int i = 0; i < times.length; i++) {
            // 指向的源节点
            int from = times[i][0];
            // 被指向的节点
            int to = times[i][1];
            // 之间的时延
            int time = times[i][2];
            // 这里的以出发节点为外层数组，然后将被指向节点 和 其时延加入到数组中
            graph[from].add(new int[]{to, time});
        }

        // 通过dijkstra找到最短路径集合
        int[] dijkstra = dijkstra(start, graph);

        int res = 0;
        for (int i = 1; i < dijkstra.length; i++) {
            if (dijkstra[i] == Integer.MAX_VALUE) {
                // 这里就存在节点不能到达指定节点的情况
                return -1;
            }
            res = Math.max(res, dijkstra[i]);
        }
        return res;
    }

    public int[] dijkstra(int start, List<int[]>[] graph) {
        // 构建一个可能最短路径的数组
        int[] distTo = new int[graph.length];
        // 填充为最大值
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // 设置开始节点的最短路径为0
        distTo[start] = 0;
        // 创建队列，并排序，将最小的放在前面
        Queue<State> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s.distFromStart));
        // 将开始节点放入到队列之中
        queue.offer(new State(start, 0));
        // 开始遍历找到最终的结果
        while (!queue.isEmpty()) {
            // 拿出当前节点来判断
            State poll = queue.poll();
            int currNodeId = poll.getId();
            int currDist = poll.getDistFromStart();
            // 如果已经是最小值，那么不做任何处理
            if (currDist > distTo[currNodeId]) {
                continue;
            }
            // 没有结束节点，所以不比较最终节点，那就比较当前节点的相邻节点
            for (int[] ints : graph[currNodeId]) {
                int nextNodeId = ints[0];
                int time = ints[1];
                // 将当前节点和之前节点相加，在进行比较
                int newNextDist = currDist + time;
                // 如果这个更小
                if (newNextDist < distTo[nextNodeId]) {
                    distTo[nextNodeId] = newNextDist;
                    queue.offer(new State(nextNodeId, newNextDist));
                }
            }
        }
        return distTo;
    }
}
