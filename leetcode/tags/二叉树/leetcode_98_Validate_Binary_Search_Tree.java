package com.claus.binaryTree;

import java.util.LinkedList;
import java.util.Stack;

public class leetcode_98_Validate_Binary_Search_Tree {
    public boolean isValidBST_1(TreeNode root) {
        return isBST_recursive(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isBST_recursive(TreeNode node, long max_val, long min_val){
        if (node == null) {
            return true;
        }
        if (node.val >= max_val || node.val <= min_val) {
            return false;
        }
        return isBST_recursive(node.left, node.val, min_val) && isBST_recursive(node.right, max_val, node.val);
    }

    public boolean isValidBST(TreeNode root) {
        // 二叉搜索树的中序遍历是有序的
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr!=null || !stack.isEmpty()) {
            while (curr!=null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev!=null && prev.val >= curr.val) {
                return false;
            }
            prev = curr;
            curr = curr.right;
        }
        return true;
    }


}
