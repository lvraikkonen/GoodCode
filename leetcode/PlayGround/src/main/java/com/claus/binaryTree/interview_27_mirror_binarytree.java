/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: interview_27_mirror_binarytree
 * Author:   lvshuo
 * Date:     2020/2/19 11:51
 * Description: 二叉树的镜像
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.claus.binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈一句话功能简述〉<br> 
 * 〈二叉树的镜像〉
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @author lvshuo
 * @create 2020/2/19
 * @since 1.0.0
 */
public class interview_27_mirror_binarytree{

    private void invertTreeNode(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public TreeNode mirrorTree_recursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree_recursive(root.left);
        mirrorTree_recursive(root.right);

        return root;
    }

    public TreeNode mirrorTree_preorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (node!=null || !stack.isEmpty()) {
            if (node != null) {
                // 交换左右子树
                invertTreeNode(node);
                // 先序遍历 根左右
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return root;
    }

    public TreeNode mirrorTree_inorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (node!=null || !stack.isEmpty()) {
            if (node!=null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                // 交换左右子树
                invertTreeNode(node);
                node = node.left;
            }
        }

        return root;
    }

    public TreeNode mirrorTree_postorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root;
        TreeNode tempNode = null; //上次访问的节点
        Deque<TreeNode> stack = new LinkedList<>();
        while (node!=null || !stack.isEmpty()) {
            if (node!=null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if (node.right == null || node.right == tempNode) {
                    //右节点为空或者右节点已经被访问过
                    //当前结点出栈
                    tempNode = stack.pop();
                    // 交换左右节点
                    invertTreeNode(node);
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
        return root;
    }


    public TreeNode mirrorTree_levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            // 翻转左右子树
            invertTreeNode(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}