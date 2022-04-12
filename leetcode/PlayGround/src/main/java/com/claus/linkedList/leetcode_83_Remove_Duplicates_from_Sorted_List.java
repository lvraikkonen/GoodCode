package com.claus.linkedList;

public class leetcode_83_Remove_Duplicates_from_Sorted_List {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current!=null && current.next!=null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates_1(ListNode head) {
        // 双指针方法
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        leetcode_83_Remove_Duplicates_from_Sorted_List s = new leetcode_83_Remove_Duplicates_from_Sorted_List();
        ListNode res = s.deleteDuplicates_1(head);
    }
}
