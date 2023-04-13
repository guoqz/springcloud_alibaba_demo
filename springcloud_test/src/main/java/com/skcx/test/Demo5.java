package com.skcx.test;

public class Demo5 {
    public static void main(String[] args) {
        int[] arr = {2, 11, 15, 19, 30, 32, 61, 72, 88, 90, 96};
        int index = binary_search(arr, arr.length, 15);
        System.out.println(index);
    }

    private static int binary_search(int[] arr, int len, int tar) {
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (arr[middle] == tar) {
                return middle;
            } //在左半边
            else if (arr[middle] > tar) {
                high = middle - 1;
            } //在右半边
            else {
                low = middle + 1;
            }
        }
        //没找到
        return -1;
    }
}
