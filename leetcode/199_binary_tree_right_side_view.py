# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        result = []
        queue = [root]
        while queue:
            size = len(queue)
            for i in range(size):
                top = queue.pop(0)
                if i == 0:
                    result.append(top.val)
                # right node in queue first
                if top.right:
                    queue.append(top.right)
                if top.left:
                    queue.append(top.left)
        return result



if __name__ == "__main__":
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)

    solution = Solution()
    result = solution.rightSideView(root)