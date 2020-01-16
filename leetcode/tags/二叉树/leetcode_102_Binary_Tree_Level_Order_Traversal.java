package com.claus.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(new LinkedList<Integer>());
        }
        res.get(depth).add(root.val);
        helper(res, root.left, depth+1);
        helper(res, root.right, depth+1);
    }
}
