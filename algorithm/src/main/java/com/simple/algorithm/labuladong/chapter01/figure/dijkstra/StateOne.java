package com.simple.algorithm.labuladong.chapter01.figure.dijkstra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-12-20 16:52
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateOne {
    private int x;
    private int y;
    // 从起点 (0, 0) 到当前位置的最小体力消耗（距离）
    private int effortFromStart;
}
