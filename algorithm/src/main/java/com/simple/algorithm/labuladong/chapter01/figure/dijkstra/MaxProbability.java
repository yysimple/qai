package com.simple.algorithm.labuladong.chapter01.figure.dijkstra;

import org.junit.Test;

import java.util.*;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-21 21:14
 **/
public class MaxProbability {

    @Test
    public void test() {
        int[][] times = new int[3][2];
        times[0] = new int[]{0, 1};
        times[1] = new int[]{1, 2};
        times[2] = new int[]{0, 2};
        System.out.println(maxProbability(3, times, new double[]{0.5, 0.5, 0.2}, 0, 2));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        // 构建邻接表
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            // 这里是有点不相同的地方，这里将无向图构建成双向图
            graph[from].add(new double[]{(double) to, weight});
            graph[to].add(new double[]{(double) from, weight});
        }
        return dijkstra(start, end, graph);
    }

    /**
     * 这里的思维需要转变一下，因为这里计算的是概率
     *
     * @param start
     * @param end
     * @param graph
     * @return
     */
    private double dijkstra(int start, int end, List<double[]>[] graph) {
        double[] distTo = new double[graph.length];
        // 因为概率最大为 1 ，所以这里填充 -1而不是最大值
        Arrays.fill(distTo, -1);
        // 同理，开始节点的概率应该设置为 1
        distTo[start] = 1;
        // 然后初始化队列的时候，里面的顺序应该从大到小进行排列
        Queue<State> queue = new PriorityQueue<>((a, b) -> Double.compare(b.getWeight(), a.getWeight()));
        // 然后初始化第一个节点,概率为 1
        queue.offer(new State(start, 1.0));
        // 遍历队列
        while (!queue.isEmpty()) {
            State poll = queue.poll();
            int currNodeId = poll.getId();
            double weight = poll.getWeight();
            // 终点判断
            if (currNodeId == end) {
                return weight;
            }
            // 当前概率判断
            if (weight < distTo[currNodeId]) {
                continue;
            }
            // 然后遍历相邻的节点
            for (double[] doubles : graph[currNodeId]) {
                int nextNodeId = (int) doubles[0];
                double nextWeight = doubles[1];
                // 这里是计算概率。所以是相乘
                double newWeight = distTo[currNodeId] * nextWeight;
                if (newWeight > distTo[nextNodeId]) {
                    distTo[nextNodeId] = newWeight;
                    queue.offer(new State(nextNodeId, newWeight));
                }
            }
        }
        return 0;
    }
}
