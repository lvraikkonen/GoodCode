"""
给定二叉树，计算二叉树的“倾斜值”（tilt）
二叉树节点的倾斜值是指其左右子树和的差的绝对值。
空节点的倾斜值为0。
"""

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def findTilt(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.result = 0

        def subTreeSum(root):
            if not root:
                return 0
            leftSum = subTreeSum(root.left)
            rightSum = subTreeSum(root.right)
            self.result += abs(leftSum-rightSum)
            return root.val + leftSum + rightSum
        
        subTreeSum(root)
        return self.result

if __name__ == '__main__':
    node0 = TreeNode(2)
    node1 = TreeNode(5)
    node2 = TreeNode(9)
    node0.left = node1
    node0.right = node2

    s = Solution()
    result = s.findTilt(node0)
    print result