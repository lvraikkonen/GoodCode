# 递归解法
"""
左右两个节点的大小是否相同.
左节点的左孩子是否和右节点的右孩子相同.
左节点的右孩子是否和右节点的左孩子相同.
"""
# 非递归解法
"""
层级遍历
"""

from collections import deque
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def isSymmetric_recursive(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root:
            return self.help(root.left, root.right)
        return True
    
    def help(self, p, q):
        if p == None and q == None:
            return True
        if p and q and p.val == q.val:
            return self.help(p.left, q.right) and self.help(p.right, q.left)
        return False
    
    def isSymmetric_iterative1(self, root):
        """
        BFS
        """
        if not root:
            return True
        q = deque([(root.left, root.right)])
        while q:
            node1, node2 = q.popleft()
            if node1 is None and node2 is None:
                continue
            if node1 is None or node2 is None:
                return False
            if node1.val != node2.val:
                return False
            q.append((node1.left, node2.right))
            q.append((node1.right, node2.left))
        return True
    
    def isSymmetric_iterative2(self, root):
        if not root:
            return True
        current_level_nodes = [root]
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
            if list(reversed(tmp)) != tmp:
                return False
            current_level_nodes = next_level_nodes
        return True
                
                

if __name__ == "__main__":
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(3)

    solution = Solution()
    result = solution.isSymmetric_iterative2(root)