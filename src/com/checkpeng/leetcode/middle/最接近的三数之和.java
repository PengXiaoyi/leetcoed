package com.checkpeng.leetcode.middle;

import java.util.Arrays;

public class 最接近的三数之和 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-3, -2, -5, 3, -1}, -1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                result = Math.abs(result - target) < Math.abs(temp - target) ? result : temp;
                if (temp < target) {
                    j++;
                } else if (temp > target) {
                    k--;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}
