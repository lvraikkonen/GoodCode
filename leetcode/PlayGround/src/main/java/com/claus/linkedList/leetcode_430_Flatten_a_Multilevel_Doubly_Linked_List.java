package com.claus.linkedList;

import java.util.LinkedList;

public class leetcode_430_Flatten_a_Multilevel_Doubly_Linked_List {
    public MultiLevelDoubleNode flatten_stack(MultiLevelDoubleNode head) {
        if (head == null) return null;
        LinkedList<MultiLevelDoubleNode> stack = new LinkedList<>();
        MultiLevelDoubleNode curr = head;
        while (true) {
            // 如果有子节点
            if (curr.child != null) {
                // 将next结点入栈
                if (curr.next != null) {
                    stack.push(curr.next);
                }
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
            // 遍历子链表的下一个结点或者从栈中弹出next结点
            if (curr.next != null) {
                curr = curr.next;
            } else if (!stack.isEmpty()) {
                MultiLevelDoubleNode next = stack.pop();
                curr.next = next;
                next.prev = curr;
                curr = next;
            } else {
                return head;
            }
        }
    }

    public MultiLevelDoubleNode flatten_recursive(MultiLevelDoubleNode head) {
        if (head == null)  return null;
        MultiLevelDoubleNode curr = head;
        while (curr != null) {
            // 如果有子节点
            if (curr.child != null) {
                // 保留next结点
                MultiLevelDoubleNode next = curr.next;
                // 递归flatten子链表，并连接
                MultiLevelDoubleNode child = flatten_recursive(curr.child);
                curr.next = child;
                child.prev = curr;
                curr.child = null;
                // 连接原来的next结点
                if (next != null) {
                    while (curr.next != null) {
                        curr = curr.next;
                    }
                    curr.next = next;
                    next.prev = curr;
                }
            }
            curr = curr.next;
        }
        return head;
    }


    public static void main(String[] args) {

    }
}
