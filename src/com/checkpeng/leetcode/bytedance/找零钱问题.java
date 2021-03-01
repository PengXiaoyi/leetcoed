package com.checkpeng.leetcode.bytedance;


/**
 * 标题：找零钱问题
 * 描述信息
 * 现存在一堆面值为 1,2,5,11,20,50 面值的硬币，问最少需要多少个硬币才能找出总值为 N个单位的零钱
 */
public class 找零钱问题 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 11, 20, 50};
        System.out.println(changeCoins(arr, 49));

    }

    public static int changeCoins(int[] coins, int money) {
        int dp[] = new int[money + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                if (i - coins[j] >= 0) {
                    dp[i] = dp[i - coins[j]] + 1;
                    break;
                }
            }
        }
        return dp[money];
    }
}
