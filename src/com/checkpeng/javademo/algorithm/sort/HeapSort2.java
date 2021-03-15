package com.checkpeng.javademo.algorithm.sort;

import java.util.PriorityQueue;

/**
 * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 */
public class HeapSort2 {

    public static void main(String[] args) {
        int arr[] = {9, 7, 6, 8, 5, 4, 3, 2, 1};
        sort(arr);
    }

    public static int[] sort(int[] arr) {
        // 对 arr 进行拷贝，不改变参数内容

        int len = arr.length;

        PriorityQueue<Integer> maxHeap = buildMaxHeap(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.poll();
        }
        return arr;
    }

    private static PriorityQueue<Integer> buildMaxHeap(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(arr.length, (num1, num2) -> {
            return num2 - num1;
        });
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        return heap;
    }
}
