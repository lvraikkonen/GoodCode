package com.claus.binaryTree;

public class leetcode_1448_Count_Good_Nodes_in_Binary_Tree {

    private static int nodeCount=0;
    public static int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return nodeCount;
    }

    // max 保存从根节点到本节点的最大节点值
    private static void dfs(TreeNode node, int max) {
        if (node==null) {
            return;
        }
        if (node.val >= max) {
            nodeCount++;
            max = node.val;
        }
        dfs(node.left, max);
        dfs(node.right, max);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        int res = goodNodes(node1);
    }

}
