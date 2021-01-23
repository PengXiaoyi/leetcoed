package com.checkpeng.leetcode.middle;

public class 长度最小的子数组 {

    public static void main(String[] args) {
        长度最小的子数组 a = new 长度最小的子数组();
        a.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }

    public int minSubArrayLen(int s, int[] nums) {
        int now = 0;
        int rigthIndex = 0;
        int leftIndex = 0;
        int resultLen = Integer.MAX_VALUE;
        while (rigthIndex < nums.length) {
            now += nums[rigthIndex];
            rigthIndex++;
            while (now >= s) {
                if (rigthIndex - leftIndex < resultLen) {
                    resultLen = rigthIndex - leftIndex;
                } else {
                    now -= nums[leftIndex];
                    leftIndex++;
                }
            }
        }
        return resultLen == Integer.MAX_VALUE ? 0 : resultLen;
    }
}
