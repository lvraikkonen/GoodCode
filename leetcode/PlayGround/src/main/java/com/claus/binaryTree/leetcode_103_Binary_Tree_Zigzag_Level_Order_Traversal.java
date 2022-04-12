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

    public List<List<Integer>> zigzagLevelOrder_1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // flag 确定遍历方向 true时向右，false时向左
        boolean flag = true;

        // 层序遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 该层的结点
            LinkedList<Integer> level = new LinkedList<>();
            for (int i=0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (flag) {
                    level.addLast(curr.val);
                } else {
                    level.addFirst(curr.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
            }
            // 切换方向
            flag = !flag;
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        leetcode_103_Binary_Tree_Zigzag_Level_Order_Traversal s = new leetcode_103_Binary_Tree_Zigzag_Level_Order_Traversal();
        List<List<Integer>> res = s.zigzagLevelOrder_1(root);
    }
}
