from __future__ import print_function

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        # Depth-first Search
        def dfs(root, val):
            val = val * 10 + root.val
            if (root.left or root.right) is None:# leaf
                return val
            sums = 0
            if root.left:
                sums += dfs(root.left, val)
            if root.right:
                sums += dfs(root.right, val)
            return sums
        
        if not root:
            return 0
        return dfs(root, 0)
         

if __name__ == '__main__':
    s = Solution()
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(2)

    result = s.sumNumbers(root)
    print(result)