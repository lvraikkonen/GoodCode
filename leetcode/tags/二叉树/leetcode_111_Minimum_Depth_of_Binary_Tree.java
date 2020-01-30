package com.claus.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_111_Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        // 层次遍历，第一次访问到叶子结点的深度就是结果
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i=0; i<count; i++) {
                TreeNode node = queue.poll();
                if (node.left==null && node.right==null) {
                    return level + 1;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level += 1;
        }
        return level + 1;
    }
}
