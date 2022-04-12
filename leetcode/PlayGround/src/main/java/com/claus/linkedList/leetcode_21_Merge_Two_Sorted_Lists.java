package com.claus.linkedList;

public class leetcode_21_Merge_Two_Sorted_Lists {

    /*
    合并两个有序链表

    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(-1);
        ListNode head = p;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = (l1==null? l2: l1);
        return head.next;
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pointer = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1!=null && p2!=null) {
            // 将较小的节点接到pointer指针
            if (p1.val < p2.val) {
                pointer.next = p1;
                p1 = p1.next;
            } else {
                pointer.next = p2;
                p2 = p2.next;
            }
            // pointer前移
            pointer = pointer.next;
        }
        // 有一个list遍历结束了
        pointer.next = (p1==null ? p2 : p1);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode result = mergeTwoLists1(node1, node4);
    }
}
