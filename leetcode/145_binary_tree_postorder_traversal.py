# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        
    
    def postorderTraversal_recursive(self, root):
        if root:
            self.postorderTraversal_recursive(root.left)
            self.postorderTraversal_recursive(root.right)
            print root.val  