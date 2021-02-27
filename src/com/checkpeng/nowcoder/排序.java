package com.checkpeng.nowcoder;

import java.util.Arrays;

public class 排序 {

    public static void main(String[] args) {
        int arr[] = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        int[] result = MySort(arr);
    }


    public static int[] MySort(int[] arr) {
        int[] results = Arrays.copyOf(arr, arr.length);
        QuickSort(results, 0, results.length - 1);
        return results;
    }

    public static void QuickSort(int[] arr, int start, int end) {
        if (!(start < end)) {
            return;
        }
        int i = start;
        int j = end;
        int temp = arr[i];
        while (i < j) {
            // 从后往前
            while (i < j && arr[j] >= temp) {
                j--;
            }
            arr[i] = arr[j];
            // 从前往后
            while (i < j && arr[i] <= temp) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = temp;
        QuickSort(arr, start, i - 1);
        QuickSort(arr, i + 1, end);
    }

}
