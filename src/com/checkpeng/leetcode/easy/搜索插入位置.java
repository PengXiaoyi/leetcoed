package com.checkpeng.leetcode.easy;

public class 搜索插入位置 {

    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        return searchIndex(nums, 0, nums.length - 1, target);
    }

    public static int searchIndex(int[] nums, int startIndex, int endIndex, int target) {
        int mid = (startIndex + endIndex) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (endIndex <= startIndex) {
            if (nums[startIndex] < target) {
                return startIndex + 1;
            } else {
                return startIndex;
            }
        }
        if (nums[mid] > target) {
            return searchIndex(nums, startIndex, mid - 1, target);
        } else {
            return searchIndex(nums, mid + 1, endIndex, target);
        }
    }
}
