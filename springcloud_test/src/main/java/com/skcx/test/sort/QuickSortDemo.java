package com.skcx.test.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 思想：
 * 1）	选定 Pivot中心轴
 * 2）	将大于 Pivot的数字放在 Pivot的右边
 * 3）	将小于 Pivot的数字放在 Pivot的左边
 * 4）	分别对左右子序列重复前三步操作
 */

public class QuickSortDemo {
    public static void main(String[] args) {
        // 待排序数组
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 把数组分块
            int pivot = partition(arr, left, right);
            System.out.println("pivot = " + pivot);
            System.out.println(Arrays.toString(arr));
            // 基准元素左边递归
            quickSort(arr, left, pivot - 1);
            // 基准元素右边递归
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];            // 选取第一个为基准元素
        while (left < right) {
            /* 先从右往移动，直到遇见小于 pivot 的元素 */
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];         // 记录小于 pivot 的值

            /* 再从左往右移动，直到遇见大于 pivot 的元素 */
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];         // 记录大于 pivot 的值
        }
        arr[left] = pivot;                    // 记录基准元素到当前指针指向的区域
        return left;                        // 返回基准元素的索引
    }
}
