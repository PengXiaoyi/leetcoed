package com.checkpeng.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            //防止重复枚举
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                int ans = a + nums[j] + nums[k];
                if (ans == 0) {
                    List<Integer> r = new ArrayList<>();
                    r.add(a);
                    r.add(nums[j]);
                    r.add(nums[k]);
                    result.add(r);
                    j++;
                    continue;
                }
                if (ans < 0) {
                    j++;
                }
                if (ans > 0) {
                    k--;
                }
            }
        }
        return result;
    }
}
