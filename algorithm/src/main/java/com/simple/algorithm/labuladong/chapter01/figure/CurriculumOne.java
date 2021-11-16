package com.simple.algorithm.labuladong.chapter01.figure;

import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-11-16 23:01
 **/
public class CurriculumOne extends BaseTest {

    boolean[] alreadyPath;
    boolean[] visited;
    boolean hasCycle = false;

    @Test
    public void test() {

    }

    public Boolean canFinish(int curriculums, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(curriculums, prerequisites);
        return !hasCycle;
    }

    public List<Integer>[] buildGraph(int curriculums, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[curriculums];
        for (int i = 0; i < curriculums; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }
}
