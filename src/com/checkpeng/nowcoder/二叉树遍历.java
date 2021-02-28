package com.checkpeng.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树遍历 {

    public int[][] threeOrders(TreeNode root) {
        // write code here
        int[][] a = new int[3][];
        a[0] = preOrder(root);
        a[1] = inOrder(root);
        a[2] = postOrder(root);
        return a;
    }

    // 先序遍历，非递归
    public int[] preOrder(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode nowNode = root;
        while (!stack.empty() || nowNode != null) {
            if (nowNode == null) {
                nowNode = stack.pop().right;
            }
            while (nowNode != null) {
                //等同于打印
                pre.add(nowNode.val);
                //入栈
                stack.push(nowNode);
                nowNode = nowNode.left;
            }
        }
        return listToArray(pre);
    }

    // 中序遍历，非递归
    public int[] inOrder(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode nowNode = root;
        while (!stack.empty() || nowNode != null) {
            if (nowNode == null) {
                in.add(stack.peek().val);
                nowNode = stack.pop().right;
            }
            while (nowNode != null) {
                stack.push(nowNode);
                nowNode = nowNode.left;
            }
        }
        return listToArray(in);
    }

    // 后续遍历，非递归
    public int[] postOrder(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode nowNode = root;
        while (!stack.empty() || nowNode != null) {
            if (nowNode == null) {
                nowNode = stack.pop().left;
            }
            while (nowNode != null) {
                //等同于打印
                pre.add(nowNode.val);
                //入栈
                stack.push(nowNode);
                nowNode = nowNode.right;
            }
        }
        // 翻转pre
        int[] post = new int[pre.size()];
        for (int i = 0; i < post.length; i++) {
            post[i] = pre.get(pre.size() - i - 1);
        }
        return post;
    }

    public int[] listToArray(List<Integer> nowList) {
        int result[] = new int[nowList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = nowList.get(i);
        }
        return result;
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
