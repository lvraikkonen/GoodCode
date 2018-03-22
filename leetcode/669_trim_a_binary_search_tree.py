# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def trimBST_recursive(self, root, L, R):
        """
        :type root: TreeNode
        :type L: int
        :type R: int
        :rtype: TreeNode
        """
        def trim(node):
            if node:
                if node.val > R:
                    return trim(node.left)
                elif node.val < L:
                    return trim(node.right)
                else:
                    node.left = trim(node.left)
                    node.right = trim(node.right)
                    return node
        
        return trim(root)
    
    def trimBST_iterative(self, root, L, R):
        """
        :type root: TreeNode
        :type L: int
        :type R: int
        :rtype: TreeNode
        """
        while root and (root.val < L or root.val > R):
            if root.val < L:
                root = root.right
            else:
                root = root.left
        if not root:
            return None
        newRoot = root
        stack = [root]
        while stack:
            node = stack[-1]
            popNode = True
            if node.left and node.left.val < L: #check if left child is illegal
                node.left = node.left.right
                popNode = False
            if node.right and node.right.val > R: #check if right child is illegal
                node.right = node.right.left
                popNode = False
            if popNode:   #checks passed, both children are legal
                stack.pop()
                if node.left:
                    stack.append(node.left)
                if node.right:
                    stack.append(node.right)
        return newRoot


if __name__ == '__main__':
    s = Solution()
    node1 = TreeNode(3)
    node2 = TreeNode(0)
    node3 = TreeNode(4)
    node4 = TreeNode(2)
    node5 = TreeNode(1)
    node1.left = node2
    node1.right = node3
    node2.right = node4
    node4.left = node5

    s.trimBST_iterative(node1, 1, 3)