package com.checkpeng.leetcode.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {9, 7, 6, 8, 5, 4, 3, 2, 1};
        bubbleSort(arr);
    }

    /**
     * 冒泡排序：每次都找最大的冒到后面去
     * 平均时间复杂度O(n方)
     * 最大时间复杂度O(n方)
     * 最好时间复杂度O(n)
     * 空间复杂度O(1)
     * 稳定排序
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
