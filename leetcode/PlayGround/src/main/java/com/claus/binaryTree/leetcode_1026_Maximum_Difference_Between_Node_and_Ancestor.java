package com.claus.binaryTree;

public class leetcode_1026_Maximum_Difference_Between_Node_and_Ancestor {

    private static int res = Integer.MIN_VALUE;

    public static int maxAncestorDiff(TreeNode root) {
        if (root==null) {
            return 0;
        }
        dfs(root, root.val, root.val);
        return res;
    }

    private static void dfs(TreeNode node, int max, int min) {
        if (node==null) {
            return;
        }
        max = Math.max(node.val, max);
        min = Math.min(node.val, min);
        // 到达叶子结点，判断差值最大值
        if (node.left==null && node.right==null) {
            res = Math.max(res, Math.abs(max - min));
        }
        dfs(node.left, max, min);
        dfs(node.right, max, min);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        int res = maxAncestorDiff(root);
    }
}
