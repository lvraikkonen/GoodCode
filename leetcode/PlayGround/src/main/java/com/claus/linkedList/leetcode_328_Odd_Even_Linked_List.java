package com.claus.linkedList;

public class leetcode_328_Odd_Even_Linked_List {

    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null || head.next.next==null) {
            return head;
        }
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode oddHead = odd;
        ListNode evenHead = even;

        while (head!=null && head.next!=null) {
            odd.next = head;
            even.next = head.next;
            odd = odd.next;
            even = even.next;
            head = head.next.next;
        }
        if (head!=null) {
            odd.next = head;
            odd = odd.next;
            even.next = null;
        }
        // link odd tail and even head
        odd.next = evenHead.next;
        return oddHead.next;
    }
}
