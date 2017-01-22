# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

def addTwoNumbers(l1, l2):
    head = ListNode(0)
    l = head
    carry = 0 # 进位
    while l1 or l2 or carry:
        sum, carry = carry, 0
        if l1:
            sum += l1.val
            l1 = l1.next
        if l2:
            sum += l2.val
            l2 = l2.next
        if sum > 9:
            carry = 1
            sum -= 10
        l.next = ListNode(sum)
        l = l.next
    return head.next

def addTwoNumbers_new(l1, l2):
    dummyHead = ListNode(0)
    p, q = l1, l2
    curr = dummyHead
    carry = 0
    while p or q:
        x = p.val if p != None else 0
        y = q.val if q != None else 0
        sum = carry + x + y
        carry = sum / 10
        curr.next = ListNode(sum % 10)
        curr = curr.next
        if p:
            p = p.next
        if q:
            q = q.next
    if carry > 0:
        curr.next = ListNode(carry)
    return dummyHead.next

if __name__ == "__main__":
    a1 = ListNode(2)
    a2 = ListNode(4)
    a3 = ListNode(3)
    b1 = ListNode(5)
    b2 = ListNode(6)
    b3 = ListNode(4)

    a1.next, b1.next = a2, b2
    a2.next, b2.next = a3, b3

    l1, l2 = ListNode(0), ListNode(0)
    l1.next, l2.next = a1, b1

    # result = addTwoNumbers(a1, b1)
    result = addTwoNumbers_new(a1, b1)