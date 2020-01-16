package com.claus.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class leetcode_144_Binary_Tree_Preorder_Traversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    public void preorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val); // root
            preorderTraversal(node.left, list);
            preorderTraversal(node.right, list);
        }
    }
}
