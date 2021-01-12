package com.checkpeng.leetcode.bytedance;

import com.checkpeng.leetcode.easy.实现strStr函数;

/**
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 * <p>
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 */
public class 寻找升序排列数组的目标值 {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        System.out.println(search(nums, 1));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左边有序
            if (nums[0] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                    continue;
                } else {
                    left = mid + 1;
                    continue;
                }
            }
            // 右边有序
            else {
                if (target <= nums[right] && target >= nums[mid]) {
                    left = mid + 1;
                    continue;
                } else {
                    right = mid - 1;
                    continue;
                }
            }
        }
        return -1;
    }
}
