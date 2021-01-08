package com.checkpeng.leetcode.middle;

public class 两数相除 {

    public static void main(String[] args) {
        System.out.println(divide(Integer.MAX_VALUE, 2));
    }

    // 最朴素的方法是一个个加除数，但是可以使用快速幂的思想
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            // 正数的区域比负数大
            if (dividend > 0) {
                if (dividend < Integer.MAX_VALUE) {
                    return -dividend;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else {
                return -dividend;
            }
        }
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        int a = dividend > 0 ? dividend : (-1)*dividend;
        int b = divisor > 0 ? divisor : -divisor;
        int res = div(a, b);
        if (sign > 0) {
            return res;
        } else {
            return -res;
        }
    }

    public static int div(int a, int b) {
        int count = 0;
        int tb = b;
        while (a >= tb + tb) {
            count = count + count;
            tb = tb + tb;
        }
        return count + div(a - count * b, b);
    }
}
