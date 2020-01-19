package com.claus.binaryTree;

import java.util.*;

public class leetcode_107_Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        deque.add(root);
        int level = 0;
        while (!deque.isEmpty()) {
            ans.add(new ArrayList<Integer>());
            int size = deque.size();
            for (int i=0; i<size; i++) {
                TreeNode node = deque.poll();
                ans.get(level).add(node.val);
                if (node.left != null)
                    deque.add(node.left);
                if (node.right != null)
                    deque.add(node.right);
            }
            level += 1;
        }
        Collections.reverse(ans);
        return ans;
    }
}
