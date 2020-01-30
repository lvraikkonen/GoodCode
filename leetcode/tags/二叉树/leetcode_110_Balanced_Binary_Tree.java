package com.claus.binaryTree;

public class leetcode_110_Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getTreeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(node.left);
        int rightDepth = getTreeDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
