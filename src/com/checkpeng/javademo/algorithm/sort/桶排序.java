package com.checkpeng.javademo.algorithm.sort;

import java.util.*;

/**
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
 * <p>
 * 设置一个定量的数组当作空桶；
 * 遍历输入数据，并且把数据一个一个放到对应的桶里去；
 * 对每个不是空的桶进行排序；
 * 从不是空的桶里把排好序的数据拼接起来。
 */
public class 桶排序 {

    public static void main(String[] args) {
        int arr[] = {9, 7, 6, 8, 5, 4, 3, 1, 2};
        int[] result = sort(arr);
    }

    public static int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return bucketSort(arr, 5);
    }

    private static int[] bucketSort(int arr[], int bucketSize) {
        if (arr.length == 0) {
            return arr;
        }
        // 初始化桶
        List<LinkedList<Integer>> buckets = new ArrayList<>(bucketSize);
        for (int i = 0; i < bucketSize; i++) {
            buckets.add(new LinkedList<>());
        }
        // 计算每个桶的数值区间跨度
        int maxValue = arr[0];
        int minValue = arr[0];
        // 计算桶的数量
        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
            minValue = Math.min(minValue, arr[i]);
        }
        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize + 1);
        // 把数据放到桶里
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketCount);
            buckets.get(index).add(arr[i]);
        }
        // 对每个桶进行排序
        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));
        }

        // 把桶里的数据塞回原数组里
        int j = 0;
        for (int i = 0; i < buckets.size(); i++) {
            for (Integer num : buckets.get(i)) {
                arr[j] = num;
                j++;
            }
        }
        return arr;
    }
}
