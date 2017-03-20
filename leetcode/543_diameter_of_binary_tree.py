# 给定一棵二叉树，计算任意两节点之间的边数的最大值。
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return max(self.traverse(root) - 1, 0)
        
    # help function
    def depth(self, root):
        if root is None:
            return 0
        return 1 + max(self.depth(root.left), self.depth(root.right))
    
    def traverse(self, root):
        if root is None:
            return 0
        return max(self.depth(root.left) + 1 + self.depth(root.right), self.traverse(root.left), self.traverse(root.right))
