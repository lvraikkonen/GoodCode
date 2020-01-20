package com.claus.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_104_Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int height_left = maxDepth(root.left);
        int height_right = maxDepth(root.right);
        return Math.max(height_left, height_right) + 1;
    }

    public int maxDepth_iterative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //层次遍历思想，记录二叉树的层数
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return maxDepth;
    }
}
