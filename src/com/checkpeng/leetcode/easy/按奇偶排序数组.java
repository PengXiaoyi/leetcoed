package com.checkpeng.leetcode.easy;

public class 按奇偶排序数组 {

    public static void main(String[] args) {
        int a[] = new int[]{3,4};
        sortArrayByParityII(a);
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int i = 0;
        int j = 1;
        while (i < nums.length - 1) {
            if (nums[i] % 2 != 0) {
                while (j < nums.length) {
                    if (nums[j] % 2 != 1) {
                        swap(nums, i, j);
                        j += 2;
                        break;
                    }
                    j += 2;
                }
            }
            i += 2;
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
