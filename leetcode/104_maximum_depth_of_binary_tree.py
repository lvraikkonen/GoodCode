from __future__ import print_function
from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def maxDepth_recursive(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        left = self.maxDepth_recursive(root.left)
        right = self.maxDepth_recursive(root.right)
        return max(left, right) + 1
    
    def maxDepth_BFS(self, root):
        if not root:
            return 0
        queue, height = deque(), 0
        queue.append(root)
        while queue:
            next_level = deque()
            while queue:
                node = queue.popleft()
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
            queue = next_level
            height += 1
        return height

if __name__ == "__main__":
    root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)

    solution = Solution()
    result = solution.maxDepth_BFS(root)
    print(result)