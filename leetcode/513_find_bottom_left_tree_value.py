# 二叉树层次遍历
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def findBottomLeftValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return []
        current_level_nodes = [root]
        while current_level_nodes:
            # 层次遍历
            next_level_nodes = [] # 下一层的结点
            for node in current_level_nodes:
                if node.left:
                    next_level_nodes.append(node.left)
                if node.right:
                    next_level_nodes.append(node.right)
            if not next_level_nodes: # no next level
                return current_level_nodes[0].val
            current_level_nodes = next_level_nodes
        return None

if __name__ == "__main__":
    root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)

    solution = Solution()
    result = solution.findBottomLeftValue(root)