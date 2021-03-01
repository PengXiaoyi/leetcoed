package com.checkpeng.leetcode.middle;

import java.util.Arrays;

public class 零钱兑换II {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 5};
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
