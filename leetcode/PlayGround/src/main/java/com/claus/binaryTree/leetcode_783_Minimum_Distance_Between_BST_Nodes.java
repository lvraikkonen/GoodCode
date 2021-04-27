package com.claus.binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode_783_Minimum_Distance_Between_BST_Nodes {
    static TreeNode pre = null;
    static int res = Integer.MAX_VALUE;

    public static int minDiffInBST(TreeNode root) {
        helper(root);
        return res;
    }

    public static void helper(TreeNode root) {
        if (root==null) {
            return;
        }
        helper(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        helper(root.right);
    }

    public static int minDiffInBST_iterative(TreeNode root) {
        if (root==null) {
            return 0;
        }
        TreeNode pre = null;
        int res = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root!=null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre!=null) {
                res = Math.min(res, root.val-pre.val);
            }
            pre = root;
            if (root.right!=null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(6);
        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        int res = minDiffInBST_iterative(root);
    }
}
