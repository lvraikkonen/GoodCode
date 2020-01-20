package com.claus.binaryTree;

import java.util.*;

public class leetcode_103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack_odd = new Stack<TreeNode>();
        Stack<TreeNode> stack_even = new Stack<TreeNode>();
        stack_even.push(root);
        int level = 0;
        while (!stack_even.isEmpty() || !stack_odd.isEmpty()) {
            ans.add(new ArrayList<Integer>());
            int count = 0;
            if (level % 2 == 0) { // 从左向右读
                count = stack_even.size();
                for (int i=0; i<count; i++) {
                    TreeNode node = stack_even.pop();
                    ans.get(level).add(node.val);
                    if (node.left != null) {
                        stack_odd.push(node.left);
                    }
                    if (node.right != null) {
                        stack_odd.push(node.right);
                    }
                }
            } else { // 从右向左读
                count = stack_odd.size();
                for (int i=0; i<count; i++) {
                    TreeNode node = stack_odd.pop();
                    ans.get(level).add(node.val);
                    if (node.right != null) {
                        stack_even.push(node.right);
                    }
                    if (node.left != null) {
                        stack_even.push(node.left);
                    }
                }
            }
            level += 1;
        }

        return ans;
    }
}
