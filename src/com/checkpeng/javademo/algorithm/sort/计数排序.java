package com.checkpeng.javademo.algorithm.sort;

public class 计数排序 {

    public static void main(String[] args) {
        int arr[] = {9, 7, 6, 8, 5, 4, 3, 2, 1};
        countingSort(arr);
    }

    public static int[] countingSort(int[] nums) {
        // 找出最大值和最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        // 创建数组
        int temp[] = new int[max - min + 1];
        // 对原数组计数
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i] - min] += 1;
        }
        // 排序恢复原数组
        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > 0) {
                nums[j] = i + min;
                temp[i]--;
                j++;
            }
        }
        return nums;
    }
}
