# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

"""
使用快慢指针寻找链表中点
将链表的后半部分就地逆置，然后比对前后两半的元素是否一致
"""

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None:
            return True
        #find mid node
        fast = slow = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        #reverse second half
        p, last = slow.next, None
        while p:
            next = p.next
            p.next = last
            last, p = p, next
        #check palindrome
        p1, p2 = last, head
        while p1 and p1.val == p2.val:
            p1, p2 = p1.next, p2.next
        #resume linked list(optional)
        p, last = last, None
        while p:
            next = p.next
            p.next = last
            last, p = p, next
        slow.next = last
        return p1 is None        