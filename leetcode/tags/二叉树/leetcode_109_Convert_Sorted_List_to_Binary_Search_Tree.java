package com.claus.binaryTree;

import com.claus.linkedList.ListNode;

public class leetcode_109_Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        // recursive build BST
        if (head == null) {
            return null;
        }
        ListNode mid = this.findMiddleElement(head);
        TreeNode root = new TreeNode(mid.val);
        // only one element
        if (head == mid) {
            return root;
        }
        root.left = this.sortedListToBST(head); // build left sub tree
        root.right = this.sortedListToBST(mid.next);
        return root;
    }

    private ListNode findMiddleElement(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null) {
            // find middle node
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // when slow equal to head
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }
}
