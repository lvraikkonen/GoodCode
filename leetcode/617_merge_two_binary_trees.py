from __future__ import print_function

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if not t1:
            return t2
        if not t2:
            return t1
        t1.left = self.mergeTrees(t1.left, t2.left)
        t1.right = self.mergeTrees(t1.right, t2.right)
        t1.val += t2.val
        return t1


if __name__ == '__main__':
    s = Solution()
    node_1_1 = TreeNode(1)
    node_1_2 = TreeNode(3)
    node_1_3 = TreeNode(2)
    node_1_4 = TreeNode(5)
    t1 = node_1_1
    t1.left = node_1_2
    t1.right = node_1_3
    node_1_2.left = node_1_4

    node_2_1 = TreeNode(2)
    node_2_2 = TreeNode(1)
    node_2_3 = TreeNode(3)
    node_2_4 = TreeNode(4)
    node_2_5 = TreeNode(7)
    t2 = node_2_1
    t2.left = node_2_2
    t2.right = node_2_3
    node_2_2.right = node_2_4
    node_2_3.right = node_2_5

    result = s.mergeTrees(t1, t2)
    print(result)