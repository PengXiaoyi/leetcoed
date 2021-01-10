package com.checkpeng.leetcode.mybro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * - 给定一堆左右闭合的区间，要求对重叠的区间进行合并，返回合并后的区间段。
 * 例如：【9, 10）【 1,4）,【 3,6）,【 8, 12）
 * 那么合并后的区间段为：【1, 6）, 【8, 12）
 */
public class 合并区间 {

    public static void main(String[] args) {
        int[][] intervals = {{9, 10}};
        int[][] merge = merge(intervals);
        System.out.println("");
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return 0;
                }
                return o1[0] > o2[0] ? 1 : -1;
            }
        });
        int i = 0;
        while (i < intervals.length) {
            int[] now = intervals[i];
            while (i + 1 < intervals.length && shouldMerge(now, intervals[i + 1])) {
                int[] merged = new int[2];
                merged[0] = Math.min(now[0], intervals[i + 1][0]);
                merged[1] = Math.max(now[1], intervals[i + 1][1]);
                now = merged;
                i++;
            }
            result.add(now);
            i++;
        }
        int[][] ans = new int[result.size()][2];
        result.toArray(ans);
        return ans;
    }

    public static boolean shouldMerge(int[] a, int[] b) {
        if (a[1] < b[0] || b[1] < a[0]) {
            return false;
        }
        return true;
    }
}
