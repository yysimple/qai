package com.simple.algorithm.labuladong.chapter01.figure;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-29 21:47
 **/
public class UFOne {
    /**
     * 计算分量，就是未连接数量
     */
    int count;

    /**
     * 记录一棵树
     */
    int[] parent;

    /**
     * 记录树的大小
     */
    int[] size;

    /**
     * 构造器，用来初始化
     *
     * @param n
     */
    public UFOne(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            // 刚开始自己就是自己的父节点
            parent[i] = i;
            // 初始化树的大小
            size[i] = 1;
        }
    }

    /**
     * 连接两颗树
     *
     * @param node1
     * @param node2
     */
    public void union(int node1, int node2) {
        int nodeA = find(node1);
        int nodeB = find(node2);
        // 证明两者已经连接
        if (nodeA == nodeB) {
            return;
        }

        // 否则将小树挂在大树下面
        if (size[nodeA] > size[nodeB]) {
            parent[nodeB] = nodeA;
            size[nodeA] += size[nodeB];
        } else {
            parent[nodeA] = nodeB;
            size[nodeB] += size[nodeA];
        }
        // 两个连通分量合并成一个连通分量
        count--;
    }

    /**
     * 判断两个节点是否连接
     *
     * @param node1
     * @param node2
     * @return
     */
    public boolean connected(int node1, int node2) {
        int i = find(node1);
        int i1 = find(node2);
        return parent[i] == parent[i1];
    }

    /**
     * 压缩方式找到对应的根节点
     *
     * @param node
     * @return
     */
    public int find(int node) {
        while (parent[node] != node) {
            // 这里进行了压缩
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }

    public int count() {
        return this.count;
    }


}
