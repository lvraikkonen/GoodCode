package com.claus.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_94_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    public void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            inorderTraversal(node.left, list);
            list.add(node.val); // root
            inorderTraversal(node.right, list);
        }
    }

    /**
     * 非递归实现
     * 用栈
     *
     */
    public List<Integer> inorderTraversal_iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static void morrisIn(TreeNode head) {
        if(head == null){
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right !=null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }
            System.out.print(cur.val+" ");
            cur = cur.right;
        }
        System.out.println();
    }
}
