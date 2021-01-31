package com.claus.linkedList;

public class leetcode_86_Partition_List {

    public static ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0);
        ListNode ps = smallDummy;
        ListNode pb = bigDummy;
        while (head != null) {
            if (head.val < x) {
                ps.next = head;
                ps = ps.next;
            } else {
                pb.next = head;
                pb = pb.next;
            }
            head = head.next;
        }
        // 大小链表连接
        ps.next = bigDummy.next;
        pb.next = null;
        return smallDummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node5.next = node5;
        node5.next = node6;
        //1,4,3,2,5,2
        ListNode result = partition(node1, 3);
    }
}
