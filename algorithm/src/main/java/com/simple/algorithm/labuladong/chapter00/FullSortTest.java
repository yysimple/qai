package com.simple.algorithm.labuladong.chapter00;

import com.simple.algorithm.test.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 全排序
 *
 * @author: WuChengXing
 * @create: 2021-10-12 22:38
 **/
public class FullSortTest extends BaseTest {

    /**
     * 全排序问题（回溯）：
     * <p>
     * 回溯算的大大致框架
     * result = []
     * def backtrack(路径, 选择列表):
     * if 满足结束条件:
     * result.add(路径)
     * return
     * for 选择 in 选择列表:
     * 做选择
     * backtrack(路径, 选择列表)
     * 撤销选择
     * <p>
     * <p>
     * 其核心就是这部分
     * for 选择 in 选择列表:
     * # 做选择
     * 将该选择从选择列表移除
     * 路径.add(选择)
     * backtrack(路径, 选择列表)
     * # 撤销选择
     * 路径.remove(选择)
     * 将该选择再加入选择列表
     */

    List<List<Integer>> allResult = new ArrayList<>();

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> lists = testBacktrack(nums);
        for (List<Integer> integers : lists) {
            System.out.println(integers);
        }
    }

    public List<List<Integer>> testBacktrack(int[] nums) {
        // 用来记录路劲的
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track);
        return allResult;
    }

    /**
     * 路径：记录在 track 中
     * 选择列表：nums 中不存在于 track 的那些元素
     * 结束条件：nums 中的元素全都在 track 中出现
     *
     * @param nums
     * @param track
     */
    public void backtrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            allResult.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.remove(track.size() - 1);
        }

    }
}
