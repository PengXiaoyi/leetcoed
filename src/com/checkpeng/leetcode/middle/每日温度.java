package com.checkpeng.leetcode.middle;

import java.util.Stack;

public class 每日温度 {

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] resule = new int[T.length];
        for (int i = 0; i < resule.length; i++) {
            int temprature = T[i];
            while (!stack.isEmpty() && temprature > T[stack.peek()]) {
                int preIndex = stack.pop();
                resule[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return resule;
    }
}
