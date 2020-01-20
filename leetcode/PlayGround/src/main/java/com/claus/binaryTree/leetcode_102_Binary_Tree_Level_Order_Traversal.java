package com.claus.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    /**
     * 非递归实现
     * 使用队列，将树上节点按照层次依次放入队列结构中
     */
    public List<List<Integer>> levelOrder_1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int count = queue.size();
            for (int i=0; i < count; i++) {
                TreeNode node = queue.remove();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            level++;
            ans.add(tmp);
        }
        return ans;
    }
}
