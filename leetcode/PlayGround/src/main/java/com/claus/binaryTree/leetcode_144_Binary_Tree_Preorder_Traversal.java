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

    /**
     * Morris遍历 时间复杂度为O(N)，空间复杂度为O(1)
     *
     * 记作当前节点为cur。
     *
     * 1. 如果cur无左孩子，cur向右移动（cur=cur.right）
     * 2. 如果cur有左孩子，找到cur左子树上最右的节点，记为mostright
     *    2.1如果mostright的right指针指向空，让其指向cur，cur向左移动（cur=cur.left）
     *    2.2如果mostright的right指针指向cur，让其指向空，cur向右移动（cur=cur.right）
     */
    public static void morrisPre(TreeNode head) {
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
                    System.out.print(cur.val+" ");
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }else {
                System.out.print(cur.val + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }

}
