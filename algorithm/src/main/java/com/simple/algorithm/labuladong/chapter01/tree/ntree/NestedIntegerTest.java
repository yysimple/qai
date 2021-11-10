package com.simple.algorithm.labuladong.chapter01.tree.ntree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-10 22:55
 **/
public class NestedIntegerTest {

    @Test
    public void test() {
        NestedInteger l1 = new NestedInteger(6);
        List<NestedInteger> l1s = new ArrayList<>();
        l1s.add(l1);
        NestedInteger r1 = new NestedInteger(4);
        List<NestedInteger> r1s = new ArrayList<>();
        r1s.add(r1);
        NestedInteger root = new NestedInteger(1, r1s);

        NestedIterator nestedIterator = new NestedIterator(Arrays.asList(root));
        if (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }
    }

}
