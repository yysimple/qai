package com.simple.algorithm.array;

/**
 * 项目: mianshi-test
 * <p>
 * 功能描述: 折半查找
 *
 * @author: WuChengXing
 * @create: 2021-04-12 23:47
 **/
public class ZheBanSearch {

    /**
     * 折半查询
     *
     * @param array
     */
    public static void halfSort(int[] array) {
        int low, high, mid;
        int tmp, j;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            low = 0;
            high = i - 1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (array[mid] > tmp) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (j = i - 1; j > high; j--) {
                array[j + 1] = array[j];
            }
            array[high + 1] = tmp;
        }
    }

    public static int searchInsert(int[] nums, int target) {
        // 初始化最左边和最右边的索引位置
        int left = 0;
        int right = nums.length - 1;
        //target在数组第一个位置
        if (target < nums[left]) {
            return 0;
        }
        //target在数组的末尾
        if (target > nums[right]) {
            return right + 1;
        }
        // 两者都往中间靠，以已经过了中间索引做标准
        while (left <= right) {
            //防止数值溢出
            int middle = left + (right - left) / 2;
            //target在middle右侧
            if (target > nums[middle]) {
                left = middle + 1;
                //target在middle左侧
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                //target在middle处
                return middle;
            }
        }
        //退出循环时left在right右边，target插入到较大数的位置上，此时nums[left]>nums[right]
        return left;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 6, 7, 9, 11, 15};
        int i = searchInsert(arr, 7);
        System.out.println(i);
    }
}
