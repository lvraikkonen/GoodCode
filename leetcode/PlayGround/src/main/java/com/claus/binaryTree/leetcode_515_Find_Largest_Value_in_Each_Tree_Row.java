package com.claus.binaryTree;

import java.util.*;

public class leetcode_515_Find_Largest_Value_in_Each_Tree_Row {
    public List<Integer> largestValues(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            int max_val = Integer.MIN_VALUE; // max value in this level
            for (int i = 0; i < size; i++){
                TreeNode node = deque.poll();
                if (node.val > max_val)
                    max_val = node.val;
                if (node.left != null)
                    deque.add(node.left);
                if (node.right != null)
                    deque.add(node.right);
            }
            res.add(max_val);
        }
        return res;
    }
}
