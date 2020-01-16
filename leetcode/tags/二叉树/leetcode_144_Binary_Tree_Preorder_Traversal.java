package com.claus.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class leetcode_144_Binary_Tree_Preorder_Traversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    public void preorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val); // root
            preorderTraversal(node.left, list);
            preorderTraversal(node.right, list);
        }
    }

    /**
     * 非递归实现
     * 使用栈
     * 前序遍历，先输出当前点的值，一直沿着左子树进行读取，没左子树就在右子树重复上述过程。
     */
    public List<Integer> preorderTraversal_iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            } // left end
            curr = stack.pop().right;
        }
        return res;
    }
}
