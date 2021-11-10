package com.simple.algorithm.labuladong.chapter01.tree.ntree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author WuChengXing
 * @date 2021/11/10
 */
public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedIntegers) {
        // 最后将数组
        List<Integer> result = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedIntegers) {
            traverse(nestedInteger, result);
        }
        this.iterator = result.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    private void traverse(NestedInteger root, List<Integer> result) {
        // 如果是整型，就到达了叶子节点
        if (root.isInteger()) {
            result.add(root.getInteger());
            return;
        }
        for (NestedInteger nestedInteger : root.getList()) {
            traverse(nestedInteger, result);
        }
    }
}
