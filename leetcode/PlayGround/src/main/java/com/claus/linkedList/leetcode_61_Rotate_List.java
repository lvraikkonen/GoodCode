package com.claus.linkedList;

public class leetcode_61_Rotate_List {

    public static ListNode rotateRight(ListNode head, int k) {

        if (head==null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int length = 1;
        while (fast.next!=null) {
            fast = fast.next;
            length += 1;
        }
        // 变成环
        fast.next = head;
        int steps = length - k%length;
        while (steps > 1) {
            slow = slow.next;
            steps -= 1;
        }
        // 找到新的头结点
        ListNode temp = slow.next;
        // 切断环
        slow.next = null;
        return temp;
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
        ListNode newList = rotateRight(node1, 2);
    }
}
