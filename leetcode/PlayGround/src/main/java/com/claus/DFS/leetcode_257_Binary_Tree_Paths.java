package com.claus.DFS;

import com.claus.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_257_Binary_Tree_Paths {

    // DFS 递归写法
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private static void dfs(TreeNode root, String path, List<String> res) {
        // null
        if (root == null) {
            return;
        }
        // 叶子结点, 找到了一条路径
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        // 递归遍历左右结点
        dfs(root.left, path+root.val+"->", res);
        dfs(root.right, path+root.val+"->", res);
    }

    // 深度优先非递归写法 (用栈)
    public static List<String> binaryTreePaths_1(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root==null) {
            return res;
        }
        Stack<Object> stack = new Stack<>();
        // 节点和路径成对出现
        stack.push(root);
        stack.push(root.val + "");
        while (!stack.isEmpty()) {
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            // 叶子结点，加入到结果中
            if (node.left==null && node.right==null) {
                res.add(path);
            }
            // right
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            // left
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
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

        List<String> result = binaryTreePaths_1(root);
    }

}
