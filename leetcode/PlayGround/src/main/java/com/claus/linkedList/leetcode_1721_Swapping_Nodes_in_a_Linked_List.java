package com.claus.linkedList;

public class leetcode_1721_Swapping_Nodes_in_a_Linked_List {
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode kNodePre = dummy;
        // 找到第K个结点的前驱结点
        for (int i = 1; i<k; i++) {
            kNodePre = kNodePre.next;
        }
        // 快慢指针
        ListNode slow = dummy;
        ListNode fast = kNodePre.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (kNodePre != slow) {
            ListNode kNode = kNodePre.next; // 第K个结点
            ListNode lastKNode = slow.next; // 倒数第K个结点
            // 交换
            slow.next = kNode;
            kNodePre.next = lastKNode;
            ListNode tmp = lastKNode.next;
            lastKNode.next = kNode.next;
            kNode.next = tmp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = swapNodes(node1, 2);
    }
}
