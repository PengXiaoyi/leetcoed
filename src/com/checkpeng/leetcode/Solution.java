package com.checkpeng.leetcode;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先排序，方便后面去重
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> common = new ArrayList<>();
        subSet(result, common, nums, 0);
        return result;
    }

    public void subSet(List<List<Integer>> result, List<Integer> common, int[] nums, int index) {
        result.add(new ArrayList<>(common));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            common.add(nums[i]);
            subSet(result, common, nums, i + 1);
            common.remove(common.size() - 1);
        }
    }


}

