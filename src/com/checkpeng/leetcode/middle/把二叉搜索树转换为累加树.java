package com.checkpeng.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class 把二叉搜索树转换为累加树 {

    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> inOrderList = new ArrayList<>();
        inOrder(inOrderList, root);
        int now = 0;
        for (int i = 0; i < inOrderList.size(); i++) {
            int temp = inOrderList.get(i).val;
            inOrderList.get(i).val += now;
            now = now + temp;
        }
        return root;
    }

    public void inOrder(List<TreeNode> inOrderList, TreeNode nowNode) {
        if (nowNode == null) {
            return;
        }

        inOrder(inOrderList, nowNode.right);
        inOrderList.add(nowNode);
        inOrder(inOrderList, nowNode.left);
    }

    class TreeNode {
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
