package com.simple.algorithm.labuladong.chapter01.figure.dijkstra;

import org.junit.Test;

import java.util.*;

/**
 * 功能描述: 最小体力消耗路径
 *
 * @author: WuChengXing
 * @create: 2021-12-20 16:53
 **/
public class MinEffortPath {

    @Test
    public void test() {
        int[][] times = new int[3][3];
        times[0] = new int[]{1, 2, 2};
        times[1] = new int[]{3, 8, 2};
        times[2] = new int[]{5, 3, 5};
        System.out.println(minEffortPath(times));
    }

    public int minEffortPath(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] effort = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        Queue<StateOne> queue = new PriorityQueue<>(Comparator.comparingInt(StateOne::getEffortFromStart));
        queue.offer(new StateOne(0, 0, 0));
        while (!queue.isEmpty()) {
            StateOne poll = queue.poll();
            int x = poll.getX();
            int y = poll.getY();
            int effortFromStart = poll.getEffortFromStart();

            // 如果到达了最后的节点
            if (x == (row - 1) && y == (col - 1)) {
                return effortFromStart;
            }
            // 如果当前节点的权重，大于之前存的节点的权重，跳出当前循环
            if (effortFromStart > effort[x][y]) {
                continue;
            }

            // 去遍历相邻的节点
            for (int[] neighbor : getNeighbors(matrix, x, y)) {
                int nx = neighbor[0];
                int ny = neighbor[1];
                int nextNeighbor = Math.abs(matrix[x][y] - matrix[nx][ny]);
                int newDist = Math.max(effortFromStart, nextNeighbor);
                if (effort[nx][ny] > newDist) {
                    effort[nx][ny] = newDist;
                    queue.offer(new StateOne(nx, ny, newDist));
                }
            }
        }
        return -1;
    }

    // 方向数组，上下左右的坐标偏移量
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // 返回坐标 (x, y) 的上下左右相邻坐标
    List<int[]> adj(int[][] matrix, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        // 存储相邻节点
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            // 这里就是代表x只存在左右移动，y是上下移动
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                // 索引越界
                continue;
            }
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }

    /**
     * 获取相邻的节点
     *
     * @param matrix 要传进来的矩阵
     * @param x      横坐标
     * @param y      纵坐标
     * @return
     */
    List<int[]> getNeighbors(int[][] matrix, int x, int y) {
        // 拿到行和列的长度
        int row = matrix.length, col = matrix[0].length;
        // 存储相邻节点,存的是相邻节点的坐标
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int rowMove = dir[0];
            int colMove = dir[1];
            int nx = x + rowMove;
            int ny = y + colMove;
            if (nx >= row || nx < 0 || ny >= col || ny < 0) {
                // 索引越界
                continue;
            }
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }
}
