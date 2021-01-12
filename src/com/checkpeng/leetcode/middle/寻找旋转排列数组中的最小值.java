package com.checkpeng.leetcode.middle;

class 寻找旋转排列数组中的最小值 {

    public static void main(String[] args) {
        int[] nums = {11, 13, 15, 17};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }
        return getMin(nums, 0, nums.length - 1);
    }

    public static int getMin(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }
        if (nums[mid - 1] > nums[mid]) {
            return nums[mid];
        }
        if (nums[0] < nums[mid]) {
            return getMin(nums, mid + 1, nums.length - 1);
        } else {
            return getMin(nums, start, mid - 1);
        }
    }
}
