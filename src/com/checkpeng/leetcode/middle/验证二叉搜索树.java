package com.checkpeng.leetcode.middle;

import java.util.Stack;

public class 验证二叉搜索树 {

    public int leftMax = Integer.MAX_VALUE;
    public int rightMin = Integer.MIN_VALUE;


    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long num = Long.MIN_VALUE;
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= num) {
                return false;
            }
            num = root.val;
            root = root.right;
        }
        return true;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
