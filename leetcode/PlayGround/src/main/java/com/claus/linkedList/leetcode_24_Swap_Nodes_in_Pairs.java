package com.claus.linkedList;

import java.util.Stack;

public class leetcode_24_Swap_Nodes_in_Pairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 每次向Stack中压入两个节点
        Stack<ListNode> stack = new Stack<>();
        ListNode p = new ListNode(-1);
        ListNode cur = head;
        head = p;
        while (cur!=null && cur.next!=null) {
            stack.push(cur);
            stack.push(cur.next);
            // cur 向前走两个节点
            cur = cur.next.next;
            // 栈中弹出两个节点，即倒序
            p.next = stack.pop();
            p = p.next;
            p.next = stack.pop();
            p = p.next;
        }
        if (cur!=null) {
            p.next = cur;
        }else {
            p.next = null;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = swapPairs(node1);
    }
}
