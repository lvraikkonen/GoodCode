# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

def mergeTwoLists(l1, l2):
    """
    :type l1: ListNode
    :type l2: ListNode
    :rtype: ListNode
    """
    if l1 == None:
        return l2
    if l2 == None:
        return l1
    dummy = ListNode(0)
    tmp = dummy
    while l1 and l2:
        if l1.val <= l2.val:
            tmp.next = l1
            l1 = l1.next
            tmp = tmp.next
        else:
            tmp.next = l2
            l2 = l2.next
            tmp = tmp.next
    if l2 == None:
        tmp.next = l1
    else:
        tmp.next = l2
    return dummy.next


if __name__ == "__main__":
    a1 = ListNode(1)
    a2 = ListNode(4)
    a3 = ListNode(5)
    b1 = ListNode(2)
    b2 = ListNode(3)

    a1.next = a2
    a2.next = a3
    b1.next = b2

    l = mergeTwoLists(a1, b1)