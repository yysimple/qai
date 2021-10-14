package com.simple.algorithm.labuladong.chapter00;

import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.util.*;

/**
 * @author WuChengXing
 * @date 2021/10/14
 */
public class NQueensBacktraceTest extends BaseTest {

    @Test
    public void testQueens() {
        List<List<String>> lists = solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("===================");
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonalLefts = new HashSet<>();
        Set<Integer> diagonalRights = new HashSet<>();
        backtrack(solutions, queens, n, 0, columns, diagonalLefts, diagonalRights);
        return solutions;
    }

    /**
     * 这里是核心的算法
     *
     * @param solutions  最后的结果
     * @param queens
     * @param totalRowCol   总行数，也即是皇后的数量，也可以代表总列数
     * @param row        当前行数
     * @param columns    不可以选择的 列
     * @param diagonalLefts 不可以选择的 左斜
     * @param diagonalRights 不可以选择的 右斜
     */
    public void backtrack(List<List<String>> solutions, int[] queens, int totalRowCol, int row, Set<Integer> columns, Set<Integer> diagonalLefts, Set<Integer> diagonalRights) {
        // 这里是结束条件，当到最后一行的时候，over
        if (row == totalRowCol) {
            // 这里转一层最后生成棋盘
            List<String> board = generateBoard(queens, totalRowCol);
            // 这个就是所有的情况
            solutions.add(board);
        } else {
            // 可以选择的列数（行数这个不控制，每次递归就是往下一行，下面会体现）
            for (int i = 0; i < totalRowCol; i++) {
                /**
                 * 接下来三步就是=排除不合法的选择=：不可选的 列、左上、右上
                 * 这里行不需要关心，因为是一直往下走的，然后也不用关心 左下 右下
                 */
                // 当前列中已经存在，跳过
                if (columns.contains(i)) {
                    continue;
                }

                /**
                 * 这里其实是个需要发现的公式：
                 * - 左上到右下：\ 这个的公式是 行下标 与 列下标 =之差=相等
                 * - 右上到左下：/ 这个的公式是 行下标 与 列下标 =之和=相等
                 * 这个公式需要自己总结，最好是画个图去理解：
                 * - 首先我们应该想到把所有不能放的位置，列出一些情况，然后找出那些不可以放置的位置
                 */
                // 这里就是 左上到右下
                int diagonalLeft = row - i;
                if (diagonalLefts.contains(diagonalLeft)) {
                    continue;
                }
                // 这里是 右上到左下
                int diagonalRight = row + i;
                if (diagonalRights.contains(diagonalRight)) {
                    continue;
                }

                /**
                 * 这里开始就是 “做选择”
                 */
                // 这里是记录当前行的第几列才能存放皇后的位置
                queens[row] = i;
                // 把当前列加入
                columns.add(i);
                diagonalLefts.add(diagonalLeft);
                diagonalRights.add(diagonalRight);
                // 行数 +1 ，然后进入下一层决策
                backtrack(solutions, queens, totalRowCol, row + 1, columns, diagonalLefts, diagonalRights);
                // 撤销选择，给下一行选择，当前行可以放，但是另外行或许可以
                queens[row] = -1;
                columns.remove(i);
                diagonalLefts.remove(diagonalLeft);
                diagonalRights.remove(diagonalRight);
            }
        }
    }

    /**
     * 生成棋盘
     *
     * @param queens
     * @param totalRowCol
     * @return
     */
    public List<String> generateBoard(int[] queens, int totalRowCol) {
        List<String> board = new ArrayList<>();
        // 遍历行数
        for (int i = 0; i < totalRowCol; i++) {
            // 用字符数组进行填充
            char[] row = new char[totalRowCol];
            // 每个没有皇后的位置填充 “-”
            Arrays.fill(row, '-');
            // 每一列的皇后位置
            row[queens[i]] = 'Q';
            // 然后将这行数据放到棋盘中
            board.add(new String(row));
        }
        // 最终返回真正的棋盘
        return board;
    }
}
