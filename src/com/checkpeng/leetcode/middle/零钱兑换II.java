package com.checkpeng.leetcode.middle;

import java.util.Arrays;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 */
public class 零钱兑换II {

    public static void main(String[] args) {
        int arr[] = new int[]{5, 2, 1};
        System.out.println(change(5, arr));
    }

    public static int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
