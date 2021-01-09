package com.checkpeng.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> common = new ArrayList<>();
        getSum(candidates, target, result, common, 0);
        return result;
    }

    /**
     * 使用回溯法求解，每个分支有两个选择：当前节点or直接去下一个节点
     * Index超过数组长度，或加起来超过target,就结束
     *
     * @param candidates
     * @param target
     * @param result
     * @param common
     * @param index
     */
    public void getSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> common, int index) {
        if (index >= candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<Integer>(common));
            return;
        }
        getSum(candidates, target, result, common, index + 1);
        if (target - candidates[index] >= 0) {
            common.add(candidates[index]);
            getSum(candidates, target - candidates[index], result, common, index);
            common.remove(common.size() - 1);
        }
    }


}
