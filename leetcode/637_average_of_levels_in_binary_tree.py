# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        if not root:
            return []
        current_level_nodes = [root]
        result = []
        while current_level_nodes:
            tmp = []
            next_level_nodes = []
            for node in current_level_nodes:
                tmp.append(node.val)
                if node.left:
                    next_level_nodes.append(node.left)
                if node.right:
                    next_level_nodes.append(node.right)
            result.append(float(sum(tmp)) / len(tmp))
            current_level_nodes = next_level_nodes
        return result



if __name__ == "__main__":
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)

    solution = Solution()
    result = solution.averageOfLevels(root)