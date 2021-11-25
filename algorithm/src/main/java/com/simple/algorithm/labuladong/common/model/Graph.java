package com.simple.algorithm.labuladong.common.model;

import lombok.Data;

import java.util.List;

/**
 * 功能描述: 图
 *
 * @author: WuChengXing
 * @create: 2021-11-25 22:24
 **/
@Data
public class Graph {

    private Integer val;

    private List<TreeNode>[] neighbors;
}
