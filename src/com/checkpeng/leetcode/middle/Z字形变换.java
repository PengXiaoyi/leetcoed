package com.checkpeng.leetcode.middle;

public class Z字形变换 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;// 一个Z字周期
        for (int i = 0; i < numRows; i++) {// j表示当前的周期
            for (int j = 0; j + i < n; j += cycleLen) {
                result.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)//不是第一行并且不是最后一行时的特殊处理
                    result.append(s.charAt(j + cycleLen - i));
            }
        }
        return result.toString();
    }
}
