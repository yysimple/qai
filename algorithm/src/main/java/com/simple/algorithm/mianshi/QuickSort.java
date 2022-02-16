package com.simple.algorithm.mianshi;

/**
 * 功能描述: 快速排序算法
 *
 * @author: WuChengXing
 * @create: 2022-02-15 21:45
 **/
public class QuickSort {
    public static void quickSort(int a[], int low, int high) {
        //请实现本方法
        if (low >= high) {
            return;
        }
        // 进行每轮排序，拿到新的分割点
        int newBase = qSortOne(a, low, high);
        // 使用递归进行前后段的排序
        quickSort(a, low, newBase - 1);
        quickSort(a, low + 1, high);
    }

    /**
     * 每轮排序
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    public static int qSortOne(int a[], int low, int high) {
        // 选取一个基准点
        int base = a[high];
        while (low < high) {
            // 从前半部分向后扫描
            while (low < high && a[low] <= base) {
                ++low;
            }
            // 置换位置
            a[high] = a[low];
            // 从后半部分向前扫描
            while (low < high && a[high] >= base) {
                --high;
            }
            // 置换位置
            a[low] = a[high];
        }
        // 将基准节点存入
        a[high] = base;
        return low;
    }

    public static void main(String[] args) {
        int a[] = {46, 58, 15, 45, 90, 18, 10, 62, 46};
        System.out.println("Before Sorting:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        quickSort(a, 0, 8);
        System.out.println("After Sorting:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
