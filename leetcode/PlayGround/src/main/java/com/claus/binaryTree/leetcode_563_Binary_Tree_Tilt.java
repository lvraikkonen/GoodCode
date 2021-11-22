package com.claus.binaryTree;

public class leetcode_563_Binary_Tree_Tilt {
    // recursive
    public int findTilt_recursive(TreeNode root) {
        if (root == null) return 0;
        return findTilt_recursive(root.left) + findTilt_recursive(root.right) + Math.abs(getSum_recursive(root.left) - getSum_recursive(root.right));
    }

    private int getSum_recursive(TreeNode root) {
        if (root == null) return 0;
        return getSum_recursive(root.left) + getSum_recursive(root.right) + root.val;
    }


    public int ans;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        // 在计算坡度时就进行累加
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans += Math.abs(left - right);
        return left + right + root.val;
    }
}
