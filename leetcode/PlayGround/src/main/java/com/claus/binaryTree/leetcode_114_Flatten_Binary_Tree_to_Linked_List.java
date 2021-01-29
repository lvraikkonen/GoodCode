package com.claus.binaryTree;

public class leetcode_114_Flatten_Binary_Tree_to_Linked_List {

    // 递归前序遍历
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 递归将左子树变成链表
        flatten(root.left);
        // 递归将右子树变成链表
        flatten(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        // 找到树最右边结点
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        node4.right = node5;
        flatten(root);
    }
}
