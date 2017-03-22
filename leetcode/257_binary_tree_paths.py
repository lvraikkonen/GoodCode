"""
给定一棵二叉树，返回所有“根到叶子”的路径。

例如，给定下面的二叉树：

   1
 /   \
2     3
 \
  5
所有“根到叶子”路径为：

["1->2->5", "1->3"]
"""

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def binaryTreePaths_DFS(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        self.answer = []
        if root is None:
            return self.answer
        
        def dfs(root, path):
            if root.left is None and root.right is None:
                # leaf
                self.answer.append(path)
            if root.left:
                dfs(root.left, path + '->' + str(root.left.val))
            if root.right:
                dfs(root.right, path + '->' + str(root.right.val))
        
        dfs(root, str(root.val))
        return self.answer

if __name__ == '__main__':
    node1 = TreeNode(1)
    node2 = TreeNode(2)
    node3 = TreeNode(3)
    node4 = TreeNode(5)
    
    node1.left = node2
    node1.right = node3
    node2.right = node4

    s = Solution()
    result = s.binaryTreePaths_DFS(node1)