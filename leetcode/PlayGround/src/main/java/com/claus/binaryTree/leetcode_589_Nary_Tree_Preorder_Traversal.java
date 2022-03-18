package com.claus.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {}

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }
}

public class leetcode_589_Nary_Tree_Preorder_Traversal {
    // 非递归
    public List<Integer> preorder(NNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<NNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            NNode node = stack.pop();
            res.add(node.val);
            // 子节点从右向左入栈
            for (int i=node.children.size()-1; i>=0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder_recursive(NNode root) {
        // 递归
        if (root == null)
            return res;
        res.add(root.val);
        for (NNode child : root.children)
        {
            preorder_recursive(child);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
