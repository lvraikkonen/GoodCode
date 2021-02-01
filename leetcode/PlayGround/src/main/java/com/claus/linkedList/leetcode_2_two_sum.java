package com.claus.linkedList;

public class leetcode_2_two_sum {

    /*
    两个 非空 的链表，表示两个非负的整数。
    它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

    请你将两个数相加，并以相同形式返回一个表示和的链表。

    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1==null? 0: l1.val;
            int y = l2==null? 0: l2.val;
            int sum = x+y+carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1!=null) {
                l1 = l1.next;
            }
            if (l2!=null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;

        ListNode result = addTwoNumbers(node1, node4);
    }
}
