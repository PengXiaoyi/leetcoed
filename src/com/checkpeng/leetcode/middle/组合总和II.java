package com.checkpeng.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和II {
    // 从小到大记录每个数字出现的次数
    List<int[]> freq = new ArrayList<int[]>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> sequence = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先对列表进行排序
        Arrays.sort(candidates);
        // 排序后记录数字大小以及数字顺序
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return ans;
    }

    public void dfs(int pos, int rest) {
        // 满足条件退出
        if (rest == 0) {
            ans.add(new ArrayList<Integer>(sequence));
            return;
        }
        // 所有数都用完了，或者当前target小于对当前数
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        // 不使用当前数，直接跳转至下一个数
        dfs(pos + 1, rest);

        // 最多能使用当前数几次
        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);

        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            // 每次使用当前数后，尝试直接跳去下一个数
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        // 回溯
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }
}
