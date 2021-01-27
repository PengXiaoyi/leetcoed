package com.checkpeng.leetcode.middle;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前K个高频元素 {

    public static void main(String[] args) {
        前K个高频元素 a = new 前K个高频元素();
        a.topKFrequent(new int[]{4,1,-1,2,-1,2,3},2);
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 初始化小顶堆排序规则
        PriorityQueue<int[]> topK = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 构建小顶堆
        map.forEach((num, count) -> {
            if (topK.size() == k) {
                if (topK.peek()[1] < count) {
                    topK.poll();
                    topK.offer(new int[]{num, count});
                }
            } else {
                topK.offer(new int[]{num, count});
            }
        });
        // 返回大顶堆前N个元素
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.poll()[0];
        }
        return result;
    }
}
