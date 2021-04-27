package com.claus.linkedList;

import java.util.HashSet;
import java.util.Set;

public class leetcode_142_Linked_List_Cycle_II {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode node = head;

        while(node!=null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }

    public static ListNode detectCycle_1(ListNode head) {
        // 快慢指针
        ListNode slow, fast;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 第一次相遇
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode res = detectCycle_1(node1);
    }
}
