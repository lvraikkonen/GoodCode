package com.claus.binaryTree;

import java.util.ArrayList;
import java.util.List;

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
}
