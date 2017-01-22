# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList_1(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        # 迭代写法
        newHead = ListNode(0)
        while head:
            next = head.next
            head.next = newHead.next
            newHead.next = head
            head = next
        return newHead.next

    # 递归写法
    def reverseList_2(self, head):
        return self.doReverse(head, None)

    def doReverse(self, head, newHead):
        if head is None:
            return newHead
        next = head.next
        head.next = newHead
        return self.doReverse(next, head)
