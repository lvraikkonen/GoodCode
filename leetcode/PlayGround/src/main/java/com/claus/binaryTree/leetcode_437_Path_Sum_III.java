package com.claus.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class leetcode_437_Path_Sum_III {

    // 从每个点出发，记录路径和，到达新节点，判断是否存在sum==targetSum
    public int target, res;

    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        target = targetSum;
        dfs1(root);
        return res;
    }

    void dfs1(TreeNode node) {
        // 遍历每个节点
        dfs2(node, 0);
        if (node.left != null) dfs1(node.left);
        if (node.right != null)  dfs1(node.right);
    }

    // 记录当前节点出发的路径和
    void dfs2(TreeNode node, int sum) {
        sum += node.val;
        if (sum == target) {
            res += 1;
        }
        if (node.left != null) {
            dfs2(node.left, sum);
        }
        if (node.right != null) {
            dfs2(node.right, sum);
        }
    }


    // 前缀和
    // 把问题 从树上 转化到 一维数组上 如何统计节点值之和等于 targetSum 的 路径 的数目
    // 统计 sum[x]-sum[y]=target 的数量
    private int prefixDFS(TreeNode node, Map<Integer, Integer> prefixSumCount, int targetSum, int currSum) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        currSum += node.val; // 当前前缀和

        res = prefixSumCount.getOrDefault(currSum - targetSum, 0); // 统计答案
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1); // 哈希表加入当前前缀和
        res += prefixDFS(node.left, prefixSumCount, targetSum, currSum);
        res += prefixDFS(node.right, prefixSumCount, targetSum, currSum);
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) - 1); // 哈希表删除当前前缀和（复原）

        return res;
    }

    public int pathSum2(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        return prefixDFS(root, prefixSumCount, targetSum, 0);
    }
}
