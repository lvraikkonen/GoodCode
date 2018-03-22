"""
给定一棵二叉查找树（BST），将其转化为“Greater Tree”，原始BST中的每一个节点都替换为不小于其本身的各节点的和。

“右 - 根 - 左”顺序遍历BST
"""
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def convertBST_recursive(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        self.total = 0

        def traverse(root):
            if root is None:
                return
            traverse(root.right)
            root.val += self.total
            self.total = root.val
            traverse(root.left)
        
        traverse(root)
        return root
    
    def convertBST_iterative(self, root):
        if not root:
            return None
        cur, stack, total = root, [], 0
        while stack or cur:
            while cur:
                stack.append(cur)
                cur = cur.right
            cur = stack.pop()
            total += cur.val
            cur.val = total
            cur = cur.left
        return root

if __name__ == '__main__':
    node1 = TreeNode(5)
    node2 = TreeNode(2)
    node3 = TreeNode(13)
    node1.left = node2
    node1.right = node3

    s = Solution()
    r = s.convertBST_iterative(node1)