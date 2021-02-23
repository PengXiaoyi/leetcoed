package com.checkpeng.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class 根据前序和中序重建二叉树 {

    public static void main(String[] args) {
        根据前序和中序重建二叉树 a = new 根据前序和中序重建二叉树();
        TreeNode treeNode = a.reConstructBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{3, 2, 4, 1, 6, 5, 7});
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return buildTree(pre, in);
    }

    public TreeNode buildTree(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }
        TreeNode nowNode = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return nowNode;
        }
        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                index = i;
                break;
            }
        }
        nowNode.left = buildTree(Arrays.copyOfRange(pre, 1, 1 + index), Arrays.copyOfRange(in, 0, index));
        nowNode.right = buildTree(Arrays.copyOfRange(pre, 1 + index, pre.length), Arrays.copyOfRange(in, index + 1, in.length));
        return nowNode;
    }
}
