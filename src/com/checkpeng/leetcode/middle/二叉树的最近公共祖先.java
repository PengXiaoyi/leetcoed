package com.checkpeng.leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class 二叉树的最近公共祖先 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> treeNodeMap = new HashMap<>();
        Map<Integer, Boolean> booleanMap = new HashMap<>();

        // 遍历整颗数,放入数组
        dfs(root, treeNodeMap);

        TreeNode nowNode = p;
        // 循环遍历压入p的父路径
        while (nowNode != null) {
            booleanMap.put(nowNode.val, true);
            nowNode = treeNodeMap.get(nowNode.val);
        }
        nowNode = q;
        while (nowNode != null) {
            if (booleanMap.get(nowNode.val) != null && booleanMap.get(nowNode.val)) {
                return nowNode;
            }
            nowNode = treeNodeMap.get(nowNode.val);
        }
        return null;
    }

    public void dfs(TreeNode root, Map<Integer, TreeNode> treeNodeMap) {
        if (root.left != null) {
            treeNodeMap.put(root.left.val, root);
            dfs(root.left, treeNodeMap);
        }
        if (root.right != null) {
            treeNodeMap.put(root.right.val, root);
            dfs(root.right, treeNodeMap);
        }
    }

}
