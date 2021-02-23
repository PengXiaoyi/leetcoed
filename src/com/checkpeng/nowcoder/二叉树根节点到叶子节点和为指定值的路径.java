package com.checkpeng.nowcoder;

import java.util.ArrayList;


public class 二叉树根节点到叶子节点和为指定值的路径 {

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> nowList = new ArrayList<>();
        if (root == null) {
            return result;
        }
        return dfs(result, nowList, root, sum);

        // write code here
    }

    public ArrayList<ArrayList<Integer>> dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> nowList, TreeNode nowNode, int sum) {
        nowList.add(nowNode.val);
        // 为根节点时，判断条件并返回
        if (nowNode.left == null && nowNode.right == null) {
            int n = 0;
            for (int i = 0; i < nowList.size(); i++) {
                n += nowList.get(i);
            }
            if (n == sum) {
                result.add(new ArrayList<>(nowList));
            }
            nowList.remove(nowList.size() - 1);
            return result;
        }
        if (nowNode.left != null) {
            dfs(result, nowList, nowNode.left, sum);
        }
        if (nowNode.right != null) {
            dfs(result, nowList, nowNode.right, sum);
        }
        nowList.remove(nowList.size() - 1);
        return result;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}
