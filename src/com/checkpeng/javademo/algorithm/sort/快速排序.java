package com.checkpeng.javademo.algorithm.sort;

public class 快速排序 {

    public static void main(String[] args) {
        int arr[] = {9, 74, 62, 8, 5, 4, 3, 1, 2, 12, 15};
        sort(arr);
    }

    public static int[] sort(int[] arr) {
        // 对 arr 进行拷贝，不改变参数内容
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int temp = arr[i];
            while (i < j) {
                while (i < j && arr[j] > temp) {
                    j--;
                }
                swap(arr, i, j);
                while (i < j && arr[i] < temp) {
                    i++;
                }
                swap(arr, i, j);
            }
            arr[i] = temp;

            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
