package com.checkpeng.leetcode.sort;

/**
 * 选择排序：每次选一个最小的到前面来
 * 平均时间复杂度O(n方)
 * 最大时间复杂度O(n方)
 * 最好时间复杂度O(n)
 * 空间复杂度O(1)
 * 稳定排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = {9, 7, 6, 8, 5, 4, 3, 2, 1};
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr) {
        int len = arr.length;
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
