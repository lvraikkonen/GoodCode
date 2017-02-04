# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

"""
哈希表解法（O(n+m) 时间, O(n) or O(m) 空间）
遍历链表A并将每个节点的地址/引用存储在哈希表中。
然后检查链表B中的每个节点bi：如果bi出现在哈希表中，则bi就是交点。
"""
def getIntersectionNode_hashtableSolution(headA, headB):
    """
    :type head1, head1: ListNode
    :rtype: ListNode
    """
    if not headA or not headB:
        return None
    else:
        p = {} # dict hashtable
        i = headA
        while i:
            p[i.val] = 1
            i = i.next
        i = headB
        while i:
            if i.val in p:
                return i
            else:
                i = i.next
        return None


"""
双指针解法 (O(n+m) 时间, O(1) 空间):
维护两个指针pA和pB，初始分别指向A和B。然后让它们分别遍历整个链表，每步一个节点。
当pA到达链表末尾时，让它指向B的头节点（没错，是B）；类似的当pB到达链表末尾时，重新指向A的头节点。
如果pA在某一点与pB相遇，则pA/pB就是交点。
"""
def getIntersectionNode_twoPointers(self, headA, headB):
    pA = headA
    pB = headB
    if headA == None or headB == None:
        return None
    while pA and pB:
        if pA.val != pB.val:
            if pA.next and pB.next:
                pA = pA.next
                pB = pB.next
            elif pA.next == None and pB.next != None:
                pA = headB
                pB = pB.next
            elif pA.next != None and pB.next == None:
                pA = pA.next
                pB = headA
            else:
                return None
        else:
            return pA