# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def _height(self, root):
        if root == None:
            return 0
        return max(self._height(root.left), self._height(root.right)) + 1
    
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root == None:
            return True
        if abs(self._height(root.left) - self._height(root.right)) <=1:
            return self.isBalanced(root.left) and self.isBalanced(root.right)
        else:
            return False