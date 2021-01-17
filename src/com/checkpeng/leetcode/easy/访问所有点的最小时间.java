package com.checkpeng.leetcode.easy;

public class 访问所有点的最小时间 {


    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length == 1) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            result += Math.max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1]));
        }
        return result;
    }
}
