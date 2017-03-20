# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
# 
"""
如果二叉树的左子树是一个叶子节点，则不用继续深入下去了，要找的就是它。
如果二叉树的左子树不是一个叶子节点，则递归调用此过程去获取左子树的左叶子节点的值。
而对于二叉树的右子树，则无论其是否是一个叶子节点都不会影响结果，直接递归调用获取右子树的左叶子节点值即可。
"""
class Solution_recursive(object):
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        ans = 0
        if root: 
            l, r = root.left, root.right
            if l is not None and (l.left is None and l.right is None):
                ans += l.val
            ans += self.sumOfLeftLeaves(l) + self.sumOfLeftLeaves(r)
        return ans


# help function
def isLeaf(node):
    if node is None:
        return False
    if node.left is None and node.right is None:
        return True
    return False