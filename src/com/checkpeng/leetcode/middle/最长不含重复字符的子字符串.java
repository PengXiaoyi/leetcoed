package com.checkpeng.leetcode.middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长不含重复字符的子字符串 {

    public Set<Character> nowChar = new HashSet<>();

    public int lengthOfLongestSubstring(String s) {
        int resultLen = -1;
        int leftIndex = 0;
        int rightIndex = 0;
        while (rightIndex < s.length() && leftIndex <= rightIndex) {
            if (!nowChar.contains(s.charAt(rightIndex))) {
                nowChar.add(s.charAt(rightIndex));
                rightIndex++;
                resultLen = Math.max(rightIndex - leftIndex, resultLen);
            } else {
                nowChar.remove(s.charAt(leftIndex));
                leftIndex++;
            }
        }
        return resultLen;
    }

}
