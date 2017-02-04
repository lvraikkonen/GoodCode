# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

"""
使用“快慢指针”法即可
fast指针每次向前运动两个节点，slow指针每次向前运动一个节点
如果fast和slow在链表的某处相遇，则说明链表中有环
"""

class Solution:
    # @param head, a ListNode
    # @return a boolean
    def hasCycle(self, head):
        slow = head
        fast = head
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
            if fast == slow:
                return True
        return False