package com.checkpeng.leetcode.middle;

import java.util.Arrays;

public class 零钱兑换 {

    public static void main(String[] args) {
        int[] arr = new int[]{2};
        System.out.println(coinChange(arr, 3));
    }


    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] < Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}
