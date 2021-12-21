package com.simple.algorithm.labuladong.chapter01.figure.dijkstra;

import lombok.Data;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-18 21:14
 **/
@Data
public class State {
    // 图节点的 id
    public int id;
    // 从 start 节点到当前节点的距离
    public int distFromStart;

    public double weight;

    public State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }

    public State(int id, double weight) {
        this.id = id;
        this.weight = weight;
    }
}
