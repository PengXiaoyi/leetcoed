package com.checkpeng.leetcode.easy;

public class 外观数列 {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        n = n - 1;
        StringBuilder result = new StringBuilder("1");
        for (int i = 0; i < n; i++) {
            StringBuilder b = new StringBuilder();
            for (int j = 0; j < result.length(); j++) {
                int a = 1;
                char c = result.charAt(j);
                while (j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
                    a++;
                    j++;
                }
                b.append(a);
                b.append(c);
            }
            result = b;
        }
        return result.toString();
    }
}
