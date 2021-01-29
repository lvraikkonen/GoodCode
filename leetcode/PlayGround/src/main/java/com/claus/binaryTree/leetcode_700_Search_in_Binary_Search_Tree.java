package com.claus.binaryTree;

public class leetcode_700_Search_in_Binary_Search_Tree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null || root.val==val) {
            return root;
        }
        if (root.val < val) {
            root.right = searchBST(root.right, val);
        }
        if (root.val > val) {
            root.left = searchBST(root.left, val);
        }
        return root;
    }
}
