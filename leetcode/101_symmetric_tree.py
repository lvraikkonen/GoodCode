# 递归解法
"""
左右两个节点的大小是否相同.
左节点的左孩子是否和右节点的右孩子相同.
左节点的右孩子是否和右节点的左孩子相同.
"""
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root:
            return self.help(root.left, root.right)
        return True
    
    def help(self, p, q):
        if p == None and q == None:
            return True
        if p and q and p.val == q.val:
            return self.help(p.left, q.right) and self.help(p.right, q.left)
        return False

if __name__ == "__main__":
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(3)

    solution = Solution()
    result = solution.isSymmetric(root)