package com.checkpeng.leetcode.easy;

import com.sun.deploy.util.StringUtils;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            rev += pop;
            if (rev * 10 > Integer.MAX_VALUE || rev * 10 < Integer.MIN_VALUE) {
                return 0;
            }
            if (x == 0) {
                return rev;
            }
            rev = rev * 10;
        }
        return rev;
    }
}
