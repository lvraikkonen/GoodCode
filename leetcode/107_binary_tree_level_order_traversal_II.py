# 二叉树层次遍历
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        current_level_nodes = [root]
        result = []
        while current_level_nodes:
            # 层级遍历
            tmp = []
            next_level_nodes = []
            for node in current_level_nodes:
                tmp.append(node.val)
                if node.left:
                    next_level_nodes.append(node.left)
                if node.right:
                    next_level_nodes.append(node.right)
            result.append(tmp)
            current_level_nodes = next_level_nodes
        return result[::-1]

if __name__ == "__main__":
    root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)

    solution = Solution()
    result = solution.levelOrderBottom(root)
    print result