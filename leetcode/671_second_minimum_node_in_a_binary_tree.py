# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def findSecondMinimumValue_revursive(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.result = float('inf')
        min1 = root.val # root is the smallest

        def dfs(node):
            if not node:
                return
            if min1 < node.val < self.result:
                self.result = node.val
            dfs(node.left)
            dfs(node.right)
        
        dfs(root)

        if self.result < float('inf'):
            return self.result
        return -1

    def findSecondMinimumValue_iterative(self, root):
        """
        - root val is the smallest
        - if left/right child is bigger than root node
                then result in left/right child (no need to move subtree)
        - if left/right equal to root node, then move to subtree
        """
        if not root:
            return -1
        result, next_nodes, min1 = float('inf'), [root], root.val
        while next_nodes:
            node = next_nodes.pop()
            if not node.left:
                continue
            if node.left.val == min1:
                next_nodes.append(node.left)
            else:
                result = min(result, node.left.val)
            if node.right.val == min1:
                next_nodes.append(node.right)
            else:
                result = min(result, node.right.val)
        return result if result < float('inf') else -1


if __name__ == '__main__':
    s = Solution()
    node1 = TreeNode(2)
    node2 = TreeNode(2)
    node3 = TreeNode(5)
    node4 = TreeNode(5)
    node5 = TreeNode(7)
    node1.left = node2
    node1.right = node3
    node3.left = node4
    node3.right = node5
    result = s.findSecondMinimumValue_iterative(node1)