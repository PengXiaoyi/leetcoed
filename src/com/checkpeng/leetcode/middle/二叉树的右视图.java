package com.checkpeng.leetcode.middle;

import java.util.*;

public class 二叉树的右视图 {

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> nodeVal = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        int maxDepth = -1;
        depthQueue.add(0);
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            TreeNode nowNode = nodeQueue.remove();
            int depth = depthQueue.remove();
            if (nowNode != null) {
                maxDepth = Math.max(maxDepth, depth);

                nodeVal.put(maxDepth, nowNode.val);

                nodeQueue.add(nowNode.left);
                nodeQueue.add(nowNode.right);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }

        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            result.add(nodeVal.get(i));
        }
        return result;
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
