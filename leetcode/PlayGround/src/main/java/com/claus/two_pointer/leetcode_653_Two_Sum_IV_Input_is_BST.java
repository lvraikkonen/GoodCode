package com.claus.two_pointer;

import com.claus.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_653_Two_Sum_IV_Input_is_BST {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);

        int len = nums.size();
        int left = 0, right = len - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else
                right--;
        }
        return false;
    }

    // BST 中序遍历有序
    private void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) return;

        inOrder(node.left, nums);
        nums.add(node.val);
        inOrder(node.right, nums);
    }


    // 递归 hash查找
    public boolean findTarget_hash(TreeNode root, int k) {
        if (root == null) return false;

        return find(root, k, new HashSet<>());
    }

    private boolean find(TreeNode node, int k, Set<Integer> set) {
        if (node == null) return false;
        if (set.contains(k - node.val)) return true;
        set.add(node.val);
        return find(node.left, k, set) || find(node.right, k, set);
    }
}
