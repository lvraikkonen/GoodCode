package com.claus.binaryTree;

public class leetcode_112_Path_Sum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    // recursive
    public boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }

        sum += root.val;
        // 到达叶子结点
        if (sum == targetSum && root.left==null && root.right==null) {
            return true;
        }

        // recursive call
        return hasPathSum(root.left, targetSum, sum) || hasPathSum(root.right, targetSum, sum);
    }
}
