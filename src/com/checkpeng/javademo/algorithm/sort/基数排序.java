package com.checkpeng.javademo.algorithm.sort;

import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
 * <p>
 * 取得数组中的最大数，并取得位数；
 * arr为原始数组，从最低位开始取每个位组成radix数组；
 * 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 */
public class 基数排序 {

    public static void main(String[] args) {
        int arr[] = {9, 74, 62, 8, 5, 4, 3, 1, 2, 12, 15};
        int[] result = sort(arr);
    }

    public static int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length == 0) {
            return arr;
        }

        //获取最高位数
        int maxLength = getMaxLength(arr);
        return radixSort(arr, maxLength);
    }

    private static int[] radixSort(int[] arr, int maxLength) {
        List<LinkedList<Integer>> counter = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            counter.add(new LinkedList<>());
        }
        int dev = 10;
        int mod = 1;
        for (int i = 0; i < maxLength; i++, dev *= 10, mod *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int index = (arr[j] % dev) / mod;
                counter.get(index).add(arr[j]);
            }
            int pos = 0;
            for (LinkedList<Integer> integers : counter) {
                while (!integers.isEmpty()) {
                    arr[pos++] = integers.poll();
                }
            }
        }
        return arr;
    }

    private static int getMaxLength(int[] arr) {
        int maxValue = arr[0];
        for (int i : arr) {
            maxValue = Math.max(maxValue, i);
        }
        if (maxValue == 0) {
            return 1;
        }
        int maxLength = 0;
        while (maxValue != 0) {
            maxValue = maxValue / 10;
            maxLength++;
        }
        return maxLength;
    }
}
