# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def minDiffInBST_iterative(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        # inorder traverse
        stack = []
        curr = root
        prev = None
        result = float('inf')
        while stack or curr:
            if curr:
                stack.append(curr)
                curr = curr.left
            else:
                curr = stack.pop()
                if not prev:
                    prev = curr
                else:
                    result = min(result, curr.val-prev.val)
                    prev = curr
                curr = curr.right
        return result


if __name__ == '__main__':
    s = Solution()
    node1 = TreeNode(4)
    node2 = TreeNode(2)
    node3 = TreeNode(6)
    node4 = TreeNode(1)
    node5 = TreeNode(3)
    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5

    result = s.minDiffInBST_iterative(node1)