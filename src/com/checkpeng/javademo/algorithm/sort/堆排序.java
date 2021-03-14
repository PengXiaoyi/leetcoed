package com.checkpeng.javademo.algorithm.sort;

/**
 * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 */
public class 堆排序 {

    public static void main(String[] args) {
        int arr[] = {9, 74, 62, 8, 5, 4, 3, 1, 2, 12, 15};
        sort(arr);
    }

    public static int[] sort(int[] arr) {
        // 建立大顶堆
        buildMaxheap(arr);

        // 每次从堆顶取出最大元素放到最后,然后重新进行堆化
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
        return arr;
    }

    public static void buildMaxheap(int[] arr) {
        for (int i = (int) Math.floor(arr.length); i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    public static void heapify(int[] arr, int index, int len) {
        int largeIndex = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < len && arr[left] > arr[largeIndex]) {
            largeIndex = left;
        }
        if (right < len && arr[right] > arr[largeIndex]) {
            largeIndex = right;
        }
        if (largeIndex != index) {
            swap(arr, index, largeIndex);
            heapify(arr, largeIndex, len);
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
