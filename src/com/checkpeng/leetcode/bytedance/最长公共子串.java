package com.checkpeng.leetcode.bytedance;

public class 最长公共子串 {

    public static void main(String[] args) {
        String a = "12hhh";
        String b = "hhh12";
        System.out.println(maxStr(a, b));
    }

    /**
     * 动态规划，DP[i][j]表示当前的最长公共子序列
     * @param str1
     * @param str2
     * @return
     */
    public static String maxStr(String str1, String str2) {
        int lastIndex = 0;
        int max_len = 0;
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max_len) {
                        max_len = dp[i][j];
                        lastIndex = i;
                    }
                }
            }
        }
        return str1.substring(lastIndex - max_len, lastIndex);
    }
}
