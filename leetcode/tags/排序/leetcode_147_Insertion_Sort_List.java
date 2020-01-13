package sort;

import linkedList.ListNode;

public class leetcode_147_Insertion_Sort_List {

    public ListNode insertionSortList_1(ListNode head) {
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode cur = dummy;
            ListNode next = head.next;
            while (cur.next != null &&  cur.next.val < head.val) {
                cur = cur.next;
            }
            head.next = cur.next;
            cur.next = head;
            head = next;
        }
        return dummy.next;
    }

    public ListNode insertionSortList_2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;
            while (pre.next.val < head.next.val) pre = pre.next;

            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return dummy.next;
    }
}
