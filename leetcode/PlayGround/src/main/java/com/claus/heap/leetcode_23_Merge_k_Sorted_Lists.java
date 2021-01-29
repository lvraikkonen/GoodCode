package com.claus.heap;

import com.claus.linkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode_23_Merge_k_Sorted_Lists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length==0) {
            return null;
        }
        // 创建一个小顶堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });

        // 遍历链表数组，将每个链表的第一个元素加入到堆中
        for (int i=0; i<lists.length; i++) {
//            while (lists[i] != null) {
//                queue.add(lists[i]);
//                lists[i] = lists[i].next;
//            }
            ListNode head = lists[i];
            if (head != null) {
                queue.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        // 从堆中取出元素，组成链表，如果这个节点还有下一个节点，就将下个节点加入堆
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            dummy.next = node;
            dummy = dummy.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        dummy.next = null;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);

        ListNode node31 = new ListNode(2);
        ListNode node32 = new ListNode(6);

        node11.next = node12;
        node12.next = node13;
        node21.next = node22;
        node22.next = node23;
        node31.next = node32;
        ListNode[] lists = {node11, node21, node31};
        ListNode result = mergeKLists(lists);
    }
}
