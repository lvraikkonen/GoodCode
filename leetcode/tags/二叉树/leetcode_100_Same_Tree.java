package com.claus.binaryTree;

public class leetcode_100_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // recursive
        if (p==null && q==null) {
            return true;
        }
        if (p==null || q==null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
