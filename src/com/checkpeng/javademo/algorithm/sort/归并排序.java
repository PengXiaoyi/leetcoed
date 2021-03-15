package com.checkpeng.javademo.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
 * 若将两个有序表合并成一个有序表，称为2-路归并。
 *
 * 5.1 算法描述
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 */
public class 归并排序 {

    public static void main(String[] args) {
        int arr[] = {9, 74, 62, 8, 5, 4, 3, 1, 2, 12, 15};
        int[] sort = sort(arr);
    }

    public static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        int middle = (int) Math.floor(arr.length) / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, middle);
        int[] rightArr = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(leftArr), sort(rightArr));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int index = 0;
        int l = 0, r = 0;
        while (index < result.length) {
            if (left[l] < right[r]) {
                result[index++] = left[l++];
                if (l == left.length) {
                    while (r < right.length) {
                        result[index++] = right[r++];
                    }
                }
            } else {
                result[index++] = right[r++];
                if (r == right.length) {
                    while (l < left.length) {
                        result[index++] = left[l++];
                    }
                }
            }
            ;
        }
        return result;
    }
}
