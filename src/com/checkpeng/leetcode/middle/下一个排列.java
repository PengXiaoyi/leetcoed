package com.checkpeng.leetcode.middle;

public class 下一个排列 {

    public static void main(String[] args) {
        int[] nums = {1, 1};
        nextPermutation(nums);
        System.out.println("1");
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 找到第一个非逆序节点
        while (i >= 0 && nums[i] > nums[i + 1]) {
            i--;
        }
        // 找到后面最小的节点
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 更换后面的顺序为最小
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
