package com.claus.linkedList;

public class leetcode_725_Split_Linked_List_in_Parts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        // 统计链表长度
        int n = 0;
        ListNode tmp = head;
        while (tmp != null) {
            n += 1;
            tmp = tmp.next;
        }

        // 在分隔成的 k 个部分中，
        // 前 remainder 个部分的长度各为 quotient + 1
        // 其余每个部分的长度各为 quotient
        int quotient = n / k;
        int remainder = n % k;

        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        // 开始分割
        for (int i=0; i < k && curr!=null; i++) {
            parts[i] = curr; // 第i段的头
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j=1; j < partSize; j++) {
                curr = curr.next; // 后移partSize个元素
            }
            // 到达当前部分的尾部，拆分和下一段的连接
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        int k = 3;
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        ListNode[] res = new ListNode[k];
        leetcode_725_Split_Linked_List_in_Parts s = new leetcode_725_Split_Linked_List_in_Parts();
        res = s.splitListToParts(head, k);
    }
}
