package com.checkpeng.javademo.algorithm.bag;

/**
 * 假设有4个物品，它们的价值(v)和重量(w)如下：
 * v 2 4 3 7
 * w 2 3 5 5
 * 背包总容量为10，现在要从中选择物品装入背包中，要求物品的重量不能超过背包的容量，并且最后放在背包中物品的总价值最大。
 * 思路，每次只给自己一个物品的选项，然后再增加
 */
public class BagAll {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{2, 4, 3, 7},
                {2, 3, 5, 5}};
        System.out.println(ks3(arr, 6));
    }

    public static int ks3(int[][] arr, int cap) {
        // 动态规划数组
        int dp[][] = new int[arr[0].length + 1][cap + 1];
        // 重量数组
        int W[] = arr[0];
        // 价值数组
        int V[] = arr[1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int k = 0;
                while (k * W[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * W[i - 1]] + k * V[i - 1]);
                    k++;
                }
            }
        }
        return dp[W.length][cap];
    }
}
