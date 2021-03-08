package com.checkpeng.leetcode.middle;

public class 下一个更大元素III {

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(123456784));
    }

    public static int nextGreaterElement(int n) {
        // 判断数字是不是逆向递增的
        char[] digits = ("" + n).toCharArray();
        int k = digits.length - 2;
        while (k >= 0) {
            if (digits[k] < digits[k + 1]) {
                break;
            }
            k--;
        }
        // 没找到就返回-1
        if (k < 0) {
            return -1;
        }
        int l = digits.length - 1;
        while (l > k) {
            if (digits[l] > digits[k]) {
                break;
            }
            l--;
        }
        swap(digits, k, l);
        reverse(digits, k + 1, digits.length - 1);
        try {
            return Integer.parseInt(new String(digits));
        } catch (Exception e) {
            return -1;
        }
    }

    public static void reverse(char[] digits, int i, int j) {
        while (i < j) {
            swap(digits, i, j);
            i++;
            j--;
        }
    }

    public static void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}
