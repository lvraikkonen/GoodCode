package com.claus.binaryTree;

public class leetcode_450_Delete_Node_in_BST {

    private TreeNode getMin(TreeNode node) {
        // BST 最左边结点就是最小的
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /*
    // 1. 如果目标节点没有子节点，我们可以直接移除该目标节点。
    // 2. 如果目标节只有一个子节点，我们可以用其子节点作为替换。
    // 3. 如果目标节点有两个子节点，我们需要找到右子树中最小结点来替换，再删除该目标节点。
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) {
            return null;
        }
        if (root.val == key) { // 找到了
            if (root.left==null) return root.right;
            if (root.right==null) return root.left;
            // 有两个子节点情况
            TreeNode minNode = getMin(root.right); // 找出右边最小的结点
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}
