package com.checkpeng.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        StringBuilder str = new StringBuilder();
        geterate(0, 0, str, n, result);
        return result;
    }

    public static List<String> geterate(int left, int right, StringBuilder now, int n, List<String> result) {
        if (right == left && right == n) {
            result.add(now.toString());
            return result;
        }
        if (left < n) {
            now.append('(');
            geterate(left + 1, right, now, n, result);
            now.deleteCharAt(now.length() - 1);
        }
        if (right < left) {
            now.append(')');
            geterate(left, right + 1, now, n, result);
            now.deleteCharAt(now.length() - 1);
        }
        return result;
    }
}
