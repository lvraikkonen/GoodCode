package com.claus.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode_1305_All_Elements_in_Two_Binary_Search_Trees {

    private List<Integer> ansList;

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        ansList.add(root.val);
        dfs(root.right);
    }

    // 方法1： 中序遍历+排序 O(nlogn)
    public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
        ansList = new ArrayList<>();
        dfs(root1);
        dfs(root2);
        Collections.sort(ansList);
        return ansList;
    }

    //方法2 中序遍历 + 归并
    private void dfs(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        dfs(root.left, ansList);
        ansList.add(root.val);
        dfs(root.right, ansList);
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> ansList = new ArrayList<>();
        int size1 = list1.size();
        int size2 = list2.size();
        int index1, index2;
        for (index1 = 0, index2 = 0; index1 < size1 && index2 < size2;) {
            int num1 = list1.get(index1);
            int num2 = list2.get(index2);
            if (num1 < num2) {
                ansList.add(num1);
                index1++;
            } else {
                ansList.add(num2);
                index2++;
            }
        }

        while (index1 < size1) {
            ansList.add(list1.get(index1++));
        }

        while (index2 < size2) {
            ansList.add(list2.get(index2++));
        }

        return ansList;
    }

    // O(n)
    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
        List<Integer> ansList1 = new ArrayList<>();
        List<Integer> ansList2 = new ArrayList<>();
        dfs(root1, ansList1);
        dfs(root2, ansList2);

        return merge(ansList1, ansList2);
    }

    // 方法3 优先队列
    private PriorityQueue<Integer> priorityQueue;

    private void dfs_3(TreeNode root) {
        if (root == null) {
            return;
        }

        priorityQueue.offer(root.val);
        dfs_3(root.left);
        dfs_3(root.right);
    }

    // 方法3 优先队列
    public List<Integer> getAllElements3(TreeNode root1, TreeNode root2) {
        priorityQueue = new PriorityQueue<>();
        dfs_3(root1);
        dfs_3(root2);
        List<Integer> ansList = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            ansList.add(priorityQueue.poll());
        }
        return ansList;
    }
}
