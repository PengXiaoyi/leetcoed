package com.checkpeng.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树遍历 {

    public int[][] threeOrders(TreeNode root) {
        // write code here
        int[][] a = new int[3][];
        a[0] = preOrder();
    }


    public int[] preOrder(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode nowNode = root;
        while (!stack.empty() || nowNode != null) {
            if (nowNode == null) {
                nowNode = stack.pop();
                pre.add(nowNode.val);
            }
            while (nowNode.left != null) {
                stack.push(nowNode.left);
                nowNode = nowNode.left;
            }
        }
    }

    public int[] inOrder() {

    }

    public int[] postOrder() {

    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
