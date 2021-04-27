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

    public static ListNode deleteDuplicates_iterative(ListNode head) {

        if (head==null || head.next==null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            // 跳过重复结点
            while (cur.next!=null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                // pre 与 cur之间无重复
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
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
        ListNode res = deleteDuplicates_iterative(head);
    }
}
