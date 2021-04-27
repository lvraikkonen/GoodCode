package com.claus.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_958_Check_Completeness_of_a_Binary_Tree {
    // 层序遍历
    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reachEnd = false;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (reachEnd && curr!=null) {
                return false;
            }
            if (curr == null) {
                reachEnd = true;
                continue;
            }
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        boolean res = isCompleteTree(root);
    }
}
