from __future__ import print_function

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def isValidBST_recursive(self, root, left=float('-inf'), right=float('inf')):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        return left < root.val < right and \
               self.isValidBST_recursive(root.left, left, root.val) and \
               self.isValidBST_recursive(root.right, root.val, right)
    
    def isValidBST_iterative(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        # inorder traverse
        stack = []
        cur = root
        pre = None
        while stack or cur:
            if cur:
                stack.append(cur)
                cur = cur.left
            else:
                p = stack.pop()
                if pre and p.val <= pre.val:
                    return False
                pre = p
                cur = p.right
        return True


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

    result = s.isValidBST_iterative(t2)
    print(result)