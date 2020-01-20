package com.claus.linkedList;

import java.util.HashSet;

public class leetcode_141_Linked_List_Cycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        // HashSet用于存储遍历过的节点
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur.next != null) {
            if (!set.add(cur)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean hasCycle_fastSlow(ListNode head) {
        // 快慢指针
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                return false;
            }
            if (slow == fast) { // meet
                return true;
            }
        }
        return false;
    }
}
