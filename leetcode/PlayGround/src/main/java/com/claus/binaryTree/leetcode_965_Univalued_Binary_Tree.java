package com.claus.binaryTree;

public class leetcode_965_Univalued_Binary_Tree {

    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }

    public boolean dfs(TreeNode root, int target) {
        if (root == null) return true;
        if (root.val != target) return false;
        else return dfs(root.left, target) && dfs(root.right, target);
    }
}
