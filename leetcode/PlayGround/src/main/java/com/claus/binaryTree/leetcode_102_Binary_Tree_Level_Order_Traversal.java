package com.claus.binaryTree;

import com.claus.linkedList.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(new LinkedList<Integer>());
        }
        res.get(depth).add(root.val);
        helper(res, root.left, depth+1);
        helper(res, root.right, depth+1);
    }

    /**
     * 非递归实现
     * 使用队列，将树上节点按照层次依次放入队列结构中
     */
    public List<List<Integer>> levelOrder_1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int count = queue.size();
            for (int i=0; i < count; i++) {
                TreeNode node = queue.remove();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            level++;
            ans.add(tmp);
        }
        return ans;
    }


    // 每层变成链表
    public static ListNode[] listOfDepth(TreeNode tree) {
        // 层序遍历
        if (tree==null) {
            return new ListNode[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        List<ListNode> res = new ArrayList<>();
        ListNode dummy = new ListNode(-1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode curr = dummy;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                curr.next = new ListNode(node.val);
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
                curr = curr.next;
            }
            res.add(dummy.next);
            dummy.next = null;
        }
        return res.toArray(new ListNode[] {});
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        ListNode[] result = listOfDepth(root);
    }
}
