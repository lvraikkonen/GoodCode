# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

def removeElements(head, val):
    """
    :type head: ListNode
    :type val: int
    :rtype: ListNode
    """
    # store the head of linked list
    dummy = ListNode(0)
    dummy.next = head
    cur = dummy
    while cur and cur.next:
        if cur.next.val == val:
            cur.next = cur.next.next
        else:
            cur = cur.next
    return dummy.next

if __name__ == "__main__":
    a1 = ListNode(1)
    a2 = ListNode(2)
    a3 = ListNode(6)
    a4 = ListNode(3)
    a5 = ListNode(4)
    a6 = ListNode(5)
    a7 = ListNode(6)

    a1.next = a2
    a2.next = a3
    a3.next = a4
    a4.next = a5
    a5.next = a6
    a6.next = a7

    l = removeElements(a1, 6)
