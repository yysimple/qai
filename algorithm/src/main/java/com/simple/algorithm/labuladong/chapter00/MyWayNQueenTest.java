package com.simple.algorithm.labuladong.chapter00;

import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.util.*;

/**
 * @author WuChengXing
 * @date 2021/10/14
 */
public class MyWayNQueenTest extends BaseTest {

    @Test
    public void testQueens() {
        List<List<String>> lists = setQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("**********************");
        }
    }

    public List<List<String>> setQueens(int n) {
        List<List<String>> allResult = new ArrayList<>();
        int[] queens = new int[n];
        Set<Integer> cols = new HashSet<>();
        Set<Integer> leftUps = new HashSet<>();
        Set<Integer> rightUps = new HashSet<>();
        backtrace(allResult, queens, n, 0, cols, leftUps, rightUps);
        return allResult;
    }

    public void backtrace(List<List<String>> allResult, int[] queens, int totalRowCol, int row, Set<Integer> cols, Set<Integer> leftUps, Set<Integer> rightUps) {
        // 结束状态
        if (row == totalRowCol) {
            allResult.add(generateBoard(queens, totalRowCol));
        }

        // 选择列表，总行数和总列数一样
        for (int i = 0; i < totalRowCol; i++) {
            // 排除不允许放置的格子
            if (cols.contains(i)) {
                continue;
            }
            // 当前行减掉列
            int leftUp = row - i;
            if (leftUps.contains(leftUp)) {
                continue;
            }
            // 当前行加上列
            int rightUp = row + i;
            if (rightUps.contains(rightUp)) {
                continue;
            }

            queens[row] = i;

            // 添加选择
            cols.add(i);
            leftUps.add(leftUp);
            rightUps.add(rightUp);

            // 进入下一层决策
            backtrace(allResult,queens, totalRowCol, row + 1, cols, leftUps, rightUps);

            // 撤销
            cols.remove(i);
            leftUps.remove(leftUp);
            rightUps.remove(rightUp);

        }
    }

    public List<String> generateBoard(int[] queens, int totalRow) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < totalRow; i++) {
            char[] rowBoards = new char[totalRow];
            Arrays.fill(rowBoards, '-');
            rowBoards[queens[i]] = 'Q';
            board.add(new String(rowBoards));
        }
        return board;
    }

}
