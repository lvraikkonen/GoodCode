package com.claus.binaryTree;

import com.claus.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode_113_Binary_Tree_Paths_Sum {

    static List<List<Integer>> res = new LinkedList<>();
    static Deque<Integer> path = new LinkedList<>();

    private static void dfs(TreeNode root, int sum) {
        if (root==null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left==null && root.right==null && sum==0) {
            res.add(new LinkedList<>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);

        path.pollLast();
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.right = node3;

        List<List<Integer>> result = pathSum(root, 8);
    }
}
