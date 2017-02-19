# 二叉树层次遍历
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        current_level_nodes, result = [root], []
        while current_level_nodes:
            max_value_current_level = None
            # 层次遍历
            next_level_nodes = [] # 下一层的结点
            for node in current_level_nodes:
                max_value_current_level = max(node.val, max_value_current_level)
                if node.left:
                    next_level_nodes.append(node.left)
                if node.right:
                    next_level_nodes.append(node.right)
            result.append(max_value_current_level)
            # move to next level
            current_level_nodes = next_level_nodes
        return result

if __name__ == "__main__":
    root = TreeNode(2)
    root.left = TreeNode(1)
    root.right = TreeNode(3)

    solution = Solution()
    result = solution.largestValues(root)