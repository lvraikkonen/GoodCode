package com.claus.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1302_Deepest_Leaves_Sum {
    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return 0;
        }
        //层次遍历，最后一层的和为结果
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans = sum;
        }
        return ans;
    }
}
