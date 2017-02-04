# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

"""
加一个头结点dummy，并使用双指针p1和p2。
p1先向前移动n个节点，然后p1和p2同时移动，
当p1.next==None时，此时p2.next指的就是需要删除的节点
"""

def removeNthFromEnd(head, n):
    """
    :type head: ListNode
    :type n: int        
    :rtype: ListNode
    """
    dummy = ListNode(0)
    dummy.next = head
    p1 = p2 = dummy
    # p1 move n elements
    for i in range(n):
        p1 = p1.next
    # move p1 p2 until p1 reach the end
    while p1.next:
        p1 = p1.next
        p2 = p2.next
    # remove p2 element
    p2.next = p2.next.next
    return dummy.next

if __name__ == "__main__":
    a1 = ListNode(1)
    a2 = ListNode(2)

    a1.next = a2

    l = removeNthFromEnd(a1, 2)
