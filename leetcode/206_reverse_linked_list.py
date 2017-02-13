# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

def reverseList_1(head):
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
def reverseList_2(head):
    return self.doReverse(head, None)

def doReverse(head, newHead):
    if head is None:
        return newHead
    next = head.next
    head.next = newHead
    return self.doReverse(next, head)


if __name__ == "__main__":
    a1 = ListNode(1)
    a2 = ListNode(2)
    a3 = ListNode(3)
    # a4 = ListNode(4)
    # a5 = ListNode(5)
    # a6 = ListNode(6)
    # a7 = ListNode(7)

    a1.next = a2
    a2.next = a3
    # a4.next = a5
    # a5.next = a6
    # a6.next = a7

    l = reverseList_1(a1)