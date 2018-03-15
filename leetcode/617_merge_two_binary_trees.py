from __future__ import print_function
from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def mergeTrees_recusion(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if not t1:
            return t2
        if not t2:
            return t1
        t1.left = self.mergeTrees_recusion(t1.left, t2.left)
        t1.right = self.mergeTrees_recusion(t1.right, t2.right)
        t1.val += t2.val
        return t1
    
    def mergeTrees_BFS(self, t1, t2):
        if not t1 and not t2:
            return None
        queue1, queue2 = deque([t1]), deque([t2])
        # build a new tree
        root = TreeNode(0)
        q = deque([root])
        while queue1 and queue2:
            node1, node2, node = queue1.popleft(), queue2.popleft(), q.popleft()
            node.val = (node1 and node1.val or 0) + (node2 and node2.val or 0)
            if (node1 and node1.left) or (node2 and node2.left):
                queue1.append(node1.left)
                queue2.append(node2.left)
                node.left = TreeNode(0)
                q.append(node.left)
            if (node1 and node1.right) or (node2 and node2.right):
                queue1.append(node1.right)
                queue2.append(node2.right)
                node.right = TreeNode(0)
                q.append(node.right)
        return root

if __name__ == '__main__':
    s = Solution()
    node_1_1 = TreeNode(1)
    node_1_2 = TreeNode(3)
    t1 = node_1_1
    t1.left = node_1_2

    node_2_1 = TreeNode(7)
    node_2_2 = TreeNode(5)
    node_2_3 = TreeNode(9)
    t2 = node_2_1
    t2.left = node_2_2
    t2.right = node_2_3

    result = s.mergeTrees_BFS(t1, t2)
    print(result)