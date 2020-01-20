package com.claus.linkedList;

public class leetcode_876_Middle_of_the_Linked_List {

    public ListNode middleNode(ListNode head) {
        if (head==null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
