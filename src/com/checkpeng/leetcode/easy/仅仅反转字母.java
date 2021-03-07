package com.checkpeng.leetcode.easy;

public class 仅仅反转字母 {

    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < S.length() && right > 0 && left < right) {
            while (left < S.length() && !Character.isLetter(chars[left])) {
                left++;
            }
            while (right > 0 && !Character.isLetter(chars[right])) {
                right--;
            }
            if (left < S.length() && right > 0 && left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
