package com.checkpeng.leetcode;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("1", "9"));

    }

    public String addStrings(String num1, String num2) {
        String lowL, highL;
        if (num1.length() > num2.length()) {
            lowL = num2;
            highL = num1;
        } else {
            lowL = num1;
            highL = num2;
        }
        int i = highL.length() - 1;
        int j = lowL.length() - 1;
        int sub = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || sub != 0) {
            int a = i >= 0 ? highL.charAt(i) - '0' : 0;
            int b = j >= 0 ? lowL.charAt(j) - '0' : 0;
            int temp = a + b + sub;
            result.append(temp % 10);
            sub = temp / 10;
            i--;
            j--;
        }
        return result.reverse().toString();
    }

}

