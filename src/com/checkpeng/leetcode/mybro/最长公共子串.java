package com.checkpeng.leetcode.mybro;

public class 最长公共子串 {

    public static void main(String[] args) {
        String s1 = "123ddd";
        String s2 = "12hhh123";
        System.out.println(maxLengthSubStr(s1, s2));
    }

    public static String maxLengthSubStr(String s1, String s2) {
        String low;
        String high;
        if (s1.length() > s2.length()) {
            low = s2;
            high = s1;
        } else {
            low = s1;
            high = s2;
        }
        if (high.contains(low)) {
            return low;
        }
        int[][] dp = new int[low.length()][high.length()];
        int max = 0;
        int maxi = 0;
        int maxj = 0;
        for (int i = 0; i < low.length(); i++) {
            for (int j = 0; j < high.length(); j++) {
                if (low.charAt(i) == high.charAt(j)) {
                    dp[i][j] = (i > 0 && j > 0) ? 1 + dp[i - 1][j - 1] : 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        maxi = i;
                        maxj = j;
                    }
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return high.substring(maxj - max + 1, maxj + 1);
    }
}
