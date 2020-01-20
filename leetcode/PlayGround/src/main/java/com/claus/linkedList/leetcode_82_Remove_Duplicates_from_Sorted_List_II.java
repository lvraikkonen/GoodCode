package com.claus.linkedList;

public class leetcode_82_Remove_Duplicates_from_Sorted_List_II {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next != null && head.val == head.next.val) {
            while (head.next!=null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }
        else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
