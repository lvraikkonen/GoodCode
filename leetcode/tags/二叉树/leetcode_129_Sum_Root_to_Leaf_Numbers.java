package com.claus.binaryTree;

import java.util.Stack;

public class leetcode_129_Sum_Root_to_Leaf_Numbers {
    public int sumNumbers(TreeNode root) {

        int ans = 0;
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();// concat nodes value
        nodeStack.push(root);
        numStack.push(0);
        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            int current_num = numStack.pop() * 10 + curr.val;
            if (curr.left==null && curr.right==null) {
                ans += current_num;
            }
            if (curr.left != null) {
                nodeStack.push(curr.left);
                numStack.push(current_num);
            }
            if (curr.right != null) {
                nodeStack.push(curr.right);
                numStack.push(current_num);
            }
        }
        return ans;
    }
}
