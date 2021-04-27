package com.claus.linkedList;

public class leetcode_206_Reverse_Linked_List {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static ListNode reverseList_recursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList_recursive(head.next);
        head.next.next = head;
        head.next = null;
        return last;
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
        ListNode res = reverseList(node1);
    }
}
