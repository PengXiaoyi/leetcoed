package com.checkpeng.leetcode.easy;

import com.sun.deploy.util.StringUtils;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
    }

    public static int reverse2(int x) {
        long rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            rev = (rev * 10) + pop;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
            if (x == 0) {
                return (int) rev;
            }
        }
        return (int) rev;
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            //判断
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            } else if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            } else {
                rev = (rev * 10) + pop;
            }
            //计算
            if (x == 0) {
                break;
            }
        }
        return rev;
    }
}
