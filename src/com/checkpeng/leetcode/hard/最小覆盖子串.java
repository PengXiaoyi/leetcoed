package com.checkpeng.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串 {

    public static void main(String[] args) {
        最小覆盖子串 a = new 最小覆盖子串();
        System.out.println(a.minWindow("a", "a"));
    }

    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> now = new HashMap<>();

    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int minIndex = 0;
        int leftIndex = 0, rightIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            char a = t.charAt(i);
            need.put(a, need.getOrDefault(a, 0) + 1);
        }
        // 右指针向右扩张
        while (rightIndex < s.length()) {
            now.put(s.charAt(rightIndex), now.getOrDefault(s.charAt(rightIndex), 0) + 1);
            // 左指针向右收缩
            while (check() && leftIndex < rightIndex) {
                if (rightIndex - leftIndex + 1 < minLen) {
                    minIndex = leftIndex;
                    minLen = rightIndex - leftIndex + 1;
                }
                now.put(s.charAt(leftIndex), now.getOrDefault(s.charAt(leftIndex), 0) - 1);
                leftIndex++;
            }
            rightIndex++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minIndex, minIndex + minLen);
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            if (!now.containsKey(entry.getKey()) || now.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
