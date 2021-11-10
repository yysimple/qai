package com.simple.algorithm.labuladong.chapter01.tree.ntree;

import lombok.Data;

import java.util.List;

/**
 * @author WuChengXing
 * @date 2021/11/10
 */
@Data
public class NestedInteger {

    private Integer val;
    private List<NestedInteger> list;

    public NestedInteger(Integer val) {
        this.val = val;
        this.list = null;
    }

    public NestedInteger(Integer val, List<NestedInteger> list) {
        this.val = val;
        this.list = list;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
        this.val = null;
    }

    /**
     * 如果其中存的是一个整数，则返回 true，否则返回 false
     *
     * @return
     */
    public boolean isInteger() {
        return val != null;
    }

    /**
     * 如果其中存的是一个整数，则返回这个整数，否则返回 null
     *
     * @return
     */
    public Integer getInteger() {
        return this.val;
    }

    /**
     * 如果其中存的是一个列表，则返回这个列表，否则返回 null
     *
     * @return
     */
    public List<NestedInteger> getList() {
        return this.list;
    }
}
