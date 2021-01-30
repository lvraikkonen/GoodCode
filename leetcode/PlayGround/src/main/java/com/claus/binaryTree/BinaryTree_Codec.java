package com.claus.binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree_Codec {
    public BinaryTree_Codec() {

    }
//    // 把树转化为字符串 BFS 宽度优先方法
//    public String serialize(TreeNode root) {
//        if (root == null) {
//            return "#";
//        }
//        // Queue
//        Queue<TreeNode> queue = new LinkedList<>();
//        StringBuilder sb = new StringBuilder();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            // 如果结点为空，添加一个#符号作为空节点
//            if (node == null) {
//                sb.append("#,");
//                continue;
//            }
//            // 如果结点不为空，将当前结点添加到字符串
//            sb.append(node.val + ",");
//            // left
//            queue.add(node.left);
//            queue.add(node.right);
//        }
//        return sb.toString();
//    }

    public String serialize(TreeNode root) {
        //边界判断，如果为空就返回一个字符串"#"
        if (root == null)
            return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }


//    // 还原字符串为二叉树
//    public TreeNode deserialize(String data) {
//        // 如果是#，则为空节点
//        if (data == "#") {
//            return null;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        String[] values = data.split(",");
//        // 第一个节点就是根节点
//        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
//        queue.add(root);
//        for (int i=1; i < values.length; i++) {
//            TreeNode parent = queue.poll();
//            // 如果不是空节点，则是父节点的左子节点
//            if (!"#".equals(values[i])) {
//                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
//                parent.left = left;
//                queue.add(left);
//            }
//            // BFS 左右结点成对出现
//            if (!"#".equals(values[++i])) {
//                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
//                parent.right = right;
//                queue.add(right);
//            }
//        }
//        return root;
//    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }
    private TreeNode helper(Queue<String> queue) {
        String sVal = queue.poll();
        if (sVal.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(sVal));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        BinaryTree_Codec codec = new BinaryTree_Codec();
        String result = codec.serialize(root);
        System.out.println(result);

        TreeNode desTree = codec.deserialize(result);
    }

}
