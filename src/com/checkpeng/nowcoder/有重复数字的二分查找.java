package com.checkpeng.nowcoder;

public class 有重复数字的二分查找 {

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 4, 4, 4, 7, 7, 8, 10, 10, 11, 12, 13, 14, 15, 15, 17, 18, 19, 23, 24, 24, 24, 24, 25, 26, 26, 26, 27, 27, 28, 29, 29, 30, 33, 36, 38, 38, 40, 40, 41, 43, 43, 43, 44, 46, 46, 47, 51, 52, 52, 53, 54, 56, 57, 57, 57, 58, 58, 61, 61, 61, 62, 64, 64, 66, 66, 67, 67, 67, 70, 72, 74, 74, 74, 75, 75, 78, 78, 78, 79, 79, 80, 83, 83, 83, 83, 84, 84, 86, 88, 89, 89, 90, 91, 91, 92, 93, 93, 96};
        int n = 3;
        int v = 101;
        System.out.println(upper_bound_(n, v, a));
    }

    public static int upper_bound_(int n, int v, int[] a) {
        return getIndex(a, 0, a.length - 1, v);
    }

    public static int getIndex(int[] a, int start, int end, int target) {
        if (start > end) {
            return a.length + 1;
        }
        int in = (start + end) / 2;
        if (target > a[in]) {
            return getIndex(a, in + 1, end, target);
        } else if (target < a[in]) {
            return getIndex(a, start, in - 1, target);
        } else {
            while (in > 0 && a[in - 1] == target) {
                in--;
            }
            return in + 1;
        }
    }
}
