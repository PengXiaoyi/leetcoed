package com.checkpeng.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class 重新格式化字符串 {

    public static void main(String[] args) {
        reformat("a0b1c2");
    }

    public static String reformat(String s) {
        List<Character> digitList = new ArrayList<>();
        List<Character> letterList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                digitList.add(s.charAt(i));
            } else {
                letterList.add(s.charAt(i));
            }
        }
        if (Math.abs(digitList.size() - letterList.size()) > 1) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        if (digitList.size() > letterList.size()) {
            int i = 0;
            int j = 0;
            for (int k = 0; k < s.length(); k++) {
                if (i < digitList.size()) {
                    result.append(digitList.get(i));
                    i++;
                }
                if (j < letterList.size()) {
                    result.append(letterList.get(j));
                    j++;
                }
            }
        } else {
            int i = 0;
            int j = 0;
            for (int k = 0; k < s.length(); k++) {
                if (i < letterList.size()) {
                    result.append(letterList.get(i));
                    i++;
                }
                if (j < digitList.size()) {
                    result.append(digitList.get(j));
                    j++;
                }
            }
        }
        return result.toString();
    }

}
