package com.checkpeng.leetcode.middle;

public class 搜索旋转排序数组 {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 5));
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左边是有序的
            if (nums[0] <= nums[mid]) {
                // 目标在左边有序的范围内
                if (target < nums[mid] && target >= nums[left]) {
                    right--;
                    continue;
                } else {
                    left++;
                    continue;
                }
                // 右边是有序的
            } else {
                // 目标在右边的有序范围内
                if (nums[mid] < target && target <= nums[right]) {
                    left++;
                    continue;
                } else {
                    right--;
                    continue;
                }
            }
        }
        return -1;
    }
}
