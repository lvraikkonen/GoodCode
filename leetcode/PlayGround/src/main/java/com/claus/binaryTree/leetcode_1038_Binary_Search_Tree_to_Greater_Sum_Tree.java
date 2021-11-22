package com.claus.binaryTree;

// same to leetcode 538
public class leetcode_1038_Binary_Search_Tree_to_Greater_Sum_Tree {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            // right
            bstToGst(root.right);
            // root
            sum += root.val;
            // 更新节点值 累加
            root.val = sum;
            // left
            bstToGst(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(8);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.right = node7;
        node2.left = node5;
        node2.right = node6;
        node6.right = node8;
        leetcode_1038_Binary_Search_Tree_to_Greater_Sum_Tree solution = new leetcode_1038_Binary_Search_Tree_to_Greater_Sum_Tree();
        TreeNode res = solution.bstToGst(root);
    }
}
