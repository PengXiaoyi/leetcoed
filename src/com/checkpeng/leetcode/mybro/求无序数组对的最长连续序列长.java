package com.checkpeng.leetcode.mybro;

import java.util.Arrays;
import java.util.HashSet;

/**
 * - 一个无序正整数数组，求数组中最长连续序列的长度，时间复杂度越简单越好
 * 示例
 * Input: [100, 4, 200, 5, 3, 2] 无序整数数组
 * Output: 4 (最长连续序列[2, 3, 4, 5]的长度)
 */
public class 求无序数组对的最长连续序列长 {

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(getMaxLength(nums));
    }

    // 涉及去重时，多考虑下Set
    public static int getMaxLength(int[] nums) {
        HashSet<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int ans = 0;
        for (Integer integer : num_set) {
            // 如果有比它小1的，就跳过，减少遍历次数
            if (!num_set.contains(integer - 1)) {
                int currentNum = integer;
                int currentLong = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLong++;
                }
                ans = Math.max(currentLong, ans);
            }
        }
        return ans;
    }
}
