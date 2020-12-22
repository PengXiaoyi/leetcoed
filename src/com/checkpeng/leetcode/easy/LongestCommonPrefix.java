package com.checkpeng.leetcode.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{}));
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index <= 200) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].length() > index && strs[i + 1].length() > index && strs[i].charAt(index) == strs[i + 1].charAt(index)) {

                } else {
                    return result.toString();
                }
            }
            result.append(strs[0].charAt(index));
            index++;
        }
        return result.toString();
    }
}
