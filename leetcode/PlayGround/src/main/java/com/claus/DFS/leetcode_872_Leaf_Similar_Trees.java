package com.claus.DFS;

import com.claus.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_872_Leaf_Similar_Trees {

    // DFS遍历出叶子元素
    private void dfs(TreeNode root, List<Integer> leafNodes) {
        if (root!=null) {
            if (root.left==null && root.right==null) {
                leafNodes.add(root.val);
            }
            dfs(root.left, leafNodes);
            dfs(root.right, leafNodes);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        dfs(root1, leaf1);
        dfs(root2, leaf2);
        return leaf1.equals(leaf2);
    }
}
