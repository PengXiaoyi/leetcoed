package com.checkpeng.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class 找出最小的K个数 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(arr, 4));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length || k < 0 || input.length == 0) {
            return new ArrayList<>();
        }
        getIndex(input, 0, input.length - 1, k);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public static int getIndex(int[] arr, int start, int end, int k) {
        int m = start;
        int n = end;
        int temp = arr[m];
        while (m < n) {
            while (m < n && arr[n] >= temp) {
                n--;
            }
            arr[m] = arr[n];
            while (m < n && arr[m] <= temp) {
                m++;
            }
            arr[n] = arr[m];
        }
        arr[m] = temp;
        if (m == k - 1 || m == k) {
            return k;
        }
        if (m > k) {
            return getIndex(arr, start, m - 1, k);
        } else {
            return getIndex(arr, m + 1, end, k);
        }
    }
}
