package com.claus.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class leetcode_145_Binary_Tree_Postorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    public void postorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            postorderTraversal(node.left, list);
            postorderTraversal(node.right, list);
            list.add(node.val); // root
        }
    }
}
