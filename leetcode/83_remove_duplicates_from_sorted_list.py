"""
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,

Given 1->1->2, return 1->2.

Given 1->1->2->3->3, return 1->2->3.
"""

"""
这题要求在一个有序的链表里面删除重复的元素，只保留一个
只需要判断当前指针以及下一个指针时候重复，如果是，则删除下一个指针就可以了
"""
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return None
        node = head
        while node.next is not None:
            if node.val == node.next.val:
                # duplicate
                node.next = node.next.next
            else:
                node = node.next
        return head
    
if __name__ == '__main__':
    node1 = ListNode(1)
    node2 = ListNode(2)
    node3 = ListNode(2)
    node4 = ListNode(3)
    node5 = ListNode(3)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    s = Solution()
    newList = s.deleteDuplicates(node1)