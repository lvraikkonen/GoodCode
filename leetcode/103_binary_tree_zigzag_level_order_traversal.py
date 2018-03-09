from __future__ import print_function

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
        if not root:
            return result
        current_level_nodes = [root]
        level = 1
        while current_level_nodes:
            tmp = []
            next_level_nodes = []
            for node in current_level_nodes:
                tmp.append(node.val)
                if node.left:
                    next_level_nodes.append(node.left)
                if node.right:
                    next_level_nodes.append(node.right)
            if level % 2 == 0:
                result.append(tmp[::-1])
            else:
                result.append(tmp)
            level += 1
            current_level_nodes = next_level_nodes
        return result


if __name__ == '__main__':
    s = Solution()
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(2)

    result = s.zigzagLevelOrder(root)
    print(result)