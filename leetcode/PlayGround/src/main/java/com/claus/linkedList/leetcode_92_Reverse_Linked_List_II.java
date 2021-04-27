package com.claus.linkedList;

public class leetcode_92_Reverse_Linked_List_II {

    // 解法思想：在需要反转的区间里，每遍历到一个节点，让这个新节点来到反转部分的起始位置
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        // prev移动到第一个反转位置前一个节点
        while (curr!=null && count<left) {
            prev = prev.next;
            curr = curr.next;
            count += 1;
        }
        ListNode tail = curr;
        // 开始反转
        while (curr!=null && count<=right) {
            ListNode tmp = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            tail.next = tmp;
            curr = tmp;
            count += 1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = reverseBetween(node1, 2, 4);
    }
}
