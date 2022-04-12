package com.claus.linkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode_23_Merge_k_Sorted_Lists {
    /*
    给你一个链表数组，每个链表都已经按升序排列。

    请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length==0) {
            return null;
        }

        // 创建小顶堆，堆顶元素为最小值
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });

        // 遍历链表数组，将每个链表的第一个元素加入堆
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head != null) {
                queue.add(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode pointer = dummy;
        // 从堆中取出元素，组成链表，如果结点还有下一个结点，则入堆
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            pointer.next = node;
            pointer = node;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        node7.next = node8;
        ListNode[] lists = {node1, node4, node7};

        ListNode result = mergeKLists(lists);
    }
}
