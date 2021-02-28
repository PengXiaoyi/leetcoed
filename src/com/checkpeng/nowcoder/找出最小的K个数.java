package com.checkpeng.nowcoder;

import java.util.ArrayList;

public class 找出最小的K个数 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        getIndex(input, 0, input.length - 1, k);

    }

    public int getIndex(int[] arr, int start, int end, int k) {
        int m = start;
        int n = end;
        int temp = arr[m];
        while (m < n) {
            while (arr[n] >= temp) {
                n--;
            }
            arr[m] = arr[n];
            while (arr[m] <= temp) {
                m++;
            }
            arr[n] = arr[m];
        }
        arr[m] = temp;
        if (m == k || m == k + 1) {
            return k;
        }
        if (m > k) {
            return getIndex(arr, start, m - 1, k);
        } else {
            return getIndex(arr, m + 1, end, k);
        }
    }
}
