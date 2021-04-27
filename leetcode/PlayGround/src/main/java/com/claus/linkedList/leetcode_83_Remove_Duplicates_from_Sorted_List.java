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
}
