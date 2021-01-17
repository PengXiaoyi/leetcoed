package com.checkpeng.leetcode.sort;

/**
 * 插入排序：每次从后面拿一个数出来，插入到应该的位置
 * 平均时间复杂度O(n方)
 * 最大时间复杂度O(n方)
 * 最好时间复杂度O(n)
 * 空间复杂度O(1)
 * 稳定排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int arr[] = {9, 7, 6, 8, 5, 4, 3, 2, 1};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            // 找到自己应该插入的索引位置
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
