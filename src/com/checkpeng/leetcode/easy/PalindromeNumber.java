package com.checkpeng.leetcode.easy;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        int midNode = number.length() / 2;
        for (int i = 0; i < midNode; i++) {
            if (number.charAt(i) == number.charAt(number.length() - (i + 1))) {

            } else {
                return false;
            }
        }
        return true;
    }
}
