package com.checkpeng.leetcode.middle;

public class 跳跃游戏 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i]) {
                if (i + nums[i] < nums.length) {
                    dp[i + nums[i]] = true;
                }
                if (i - nums[i] > 0) {
                    dp[i + nums[i]] = true;
                }
            }
        }
        return false;
    }
}
