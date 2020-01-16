package com.claus.binaryTree;

import javax.management.StandardEmitterMBean;
import java.util.*;

public class leetcode_145_Binary_Tree_Postorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    public void postorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            postorderTraversal(node.left, list);
            postorderTraversal(node.right, list);
            list.add(node.val); // root
        }
    }

    /**
     * 非递归实现 1
     * 后序遍历由于要左右子树输出完后才能输出根结点
     *
     * 每个节点 push 两次，然后判断当前 pop 节点和栈顶节点是否相同。
     * 相同的话，就意味着是从左子树到的根节点。
     * 不同的话，就意味着是从右子树到的根节点，此时就可以把节点加入到 list 中
     */
    public List<Integer> postorderTraversal_1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return res;
        }
        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr == null) {
                continue;
            }
            if (!stack.isEmpty() && curr == stack.peek()) {
                // 从左子树到根，处理右子树
                stack.push(curr.right);
                stack.push(curr.right);
                stack.push(curr.left);
                stack.push(curr.left);
            } else {
                res.add(curr.val);
            }
        }
        return res;
    }

    /**
     * 非递归实现 2
     * 通过记录上一次遍历的节点
     * 判断当前是从左子树到的根节点还是右子树到的根节点
     */
    public List<Integer> postorderTraversal_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode last = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr!=null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode tmp = stack.peek();
                // 是否变到右子树
                if (tmp.right != null && tmp.right != last) {
                    curr = tmp.right;
                } else {
                    res.add(tmp.val);
                    last = tmp;
                    stack.pop();
                }
            }
        }
        return res;
    }

    /**
     * 非递归实现 3
     * 后序遍历 转换成 前序遍历
     *
     * 后序遍历的顺序是 左 -> 右 -> 根。
     * 前序遍历的顺序是 根 -> 左 -> 右，左右其实是等价的，所以我们也可以轻松的写出 根 -> 右 -> 左 的代码。
     * 然后把 根 -> 右 -> 左 逆序，就是 左 -> 右 -> 根，也就是后序遍历了。
     */
    public List<Integer> postorderTraversal_3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()) {
            if (curr!=null) {
                res.add(curr.val);
                stack.push(curr);
                curr = curr.right; //
            } else {
                curr = stack.pop().left;
            }
        }
        Collections.reverse(res);
        return res;
    }
}
