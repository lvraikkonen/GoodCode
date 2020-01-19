package com.claus.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_226_Invert_Binary_Tree {

    public TreeNode invertTree_recursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree_recursive(root.left);
        TreeNode right = invertTree_recursive(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree_iterative(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            // swap
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;

            if (curr.left!=null) {
                queue.add(curr.left);
            }
            if (curr.right!=null) {
                queue.add(curr.right);
            }
        }
        return root;
    }
}
