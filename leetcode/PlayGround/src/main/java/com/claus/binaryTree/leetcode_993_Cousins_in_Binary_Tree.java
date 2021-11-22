package com.claus.binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode_993_Cousins_in_Binary_Tree {
    public static boolean isCousin(TreeNode root, int x, int y) {
        //这两个值任意一个都不会出现在根节点
        if(root==null||root.val==x||root.val==y)
            return false;
        Deque<TreeNode> queue =new LinkedList<>();
        queue.add(root);
        //对应x值的结点
        TreeNode xNode=null;
        //对应y值的结点
        TreeNode yNode=null;
        //对应x值的父亲的结点
        TreeNode xFather=null;
        //对应y值的父亲的结点
        TreeNode yFather=null;
        // 层序遍历
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i=0; i<size; i++){
                TreeNode temp = queue.poll();
                if(temp.left!=null){
                    queue.add(temp.left);
                    //找节点
                    if(temp.left.val==x){
                        xNode=temp.left;
                        xFather=temp;
                    }
                    if(temp.left.val==y){
                        yNode=temp.left;
                        yFather=temp;}
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                    //找节点
                    if(temp.right.val==x){
                        xNode=temp.right;
                        xFather=temp;}
                    if(temp.right.val==y){
                        yNode=temp.right;
                        yFather=temp;
                    }
                }
                //两个节点都没找到
                if(xNode==null && yNode==null) continue;
                //两个节点都找到了，那么判断它们是不是堂兄弟节点
                else if(xNode!=null && yNode!=null){
                    //如果父亲结点不相等，说明是堂兄弟结点
                    return xFather!=yFather;
                }
                //这层遍历完了，但是有一个节点找到了，另外一个没找到
                else if(size==0)
                    return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
