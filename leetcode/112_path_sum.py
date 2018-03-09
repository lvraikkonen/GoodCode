from __future__ import print_function

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def hasPathSum(self, root, sums):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        # # recusion
        # if not root:
        #     return False
        # if not root.left and not root.right:#leaf
        #     return True if sums == root.val else False
        # else:
        #     return self.hasPathSum(root.left, sums - root.val) or self.hasPathSum(root.right, sums - root.val)
        
        if not root:
            return False
        
        # not recursive solution (dfs using stack)
        stack = [(root, root.val)]
        while stack:
            node, val = stack.pop()
            if not node.left and not node.right:
                if val == sums:
                    return True
            if node.left:
                stack.append((node.left, val + node.left.val))
            if node.right:
                stack.append((node.right, val + node.right.val))
        return False

        # # not recursive solution (bfs using queue)
        # queue = [(root, sums - root.val)]
        # while queue:
        #     node, val = queue.pop(0)
        #     if not node.left and not node.right:
        #         if val == 0:
        #             return True
        #     if node.left:
        #         queue.append((node.left, val - node.left.val))
        #     if node.right:
        #         queue.append((node.right, val - node.right.val))
        # return False


if __name__ == '__main__':
    s = Solution()
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(2)

    result = s.hasPathSum(root, 5)
    print(result)