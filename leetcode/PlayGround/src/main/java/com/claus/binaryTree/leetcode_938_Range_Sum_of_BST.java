package com.claus.binaryTree;

public class leetcode_938_Range_Sum_of_BST {

    /*
    若root.val < L，则符合范围的值只会出现在root的右子树；
    若root.val > R，则符合范围的值只会出现在root的左子树；
    若 L <= root.val ≤ R，则符合范围的值会出现在root的左子树或右子树；
     */
    private static int res = 0;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        // 递归先序遍历
        traverse(root, low, high);
        return res;
    }

    public static void traverse(TreeNode root, int L, int R) {
        if (root==null) {
            return;
        }
        if (root.val >= L && root.val <= R) {
            res += root.val;
            traverse(root.left, L, R);
            traverse(root.right, L, R);
        }
        // 剪枝
        if (root.val < L) {
            traverse(root.right, L, R);
        }
        if (root.val > R) {
            traverse(root.left, L, R);
        }
    }
}
