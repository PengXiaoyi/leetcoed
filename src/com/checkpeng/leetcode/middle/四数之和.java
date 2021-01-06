package com.checkpeng.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 0, 3, 3, -1};
        System.out.println(fourSum(nums, 5));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; ) {
            for (int j = i + 1; j < nums.length - 2; ) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int temp = nums[i] + nums[j] + nums[k] + nums[l];
                    if (temp == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        result.add(list);
                        l--;
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (temp < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
                j++;
                while (j < nums.length - 2 && nums[j] == nums[j - 1]) {
                    j++;
                }
            }
            i++;
            while (i < nums.length - 3 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return result;
    }
}
