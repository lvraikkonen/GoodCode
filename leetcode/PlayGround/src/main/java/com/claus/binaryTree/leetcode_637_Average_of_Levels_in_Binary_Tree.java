package com.claus.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode_637_Average_of_Levels_in_Binary_Tree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        deque.add(root);
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            long sum = 0;
            for (int i=0; i<size; i++) {
                TreeNode curr = deque.poll();
                sum += curr.val;
                if (curr.left!=null) {
                    deque.add(curr.left);
                }
                if (curr.right!=null) {
                    deque.add(curr.right);
                }
            }
            level += 1;
            ans.add((double) (sum / size));
        }
        return ans;
    }
}
