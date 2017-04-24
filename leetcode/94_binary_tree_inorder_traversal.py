# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def inorderTraversal_iterative(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        node = root
        stack = []
        result = []
        while node or stack:
            while node:
                stack.append(node)
                node = node.left
            node = stack.pop()
            result.append(node.val)
            node = node.right
        return result

        
    def inorderTraversal_recursive(self, root):
        """
        递归写法
        """
        if root:
            self.inorderTraversal_recursive(root.left)
            print root.val
            self.inorderTraversal_recursive(root.right)

if __name__ == '__main__':
    node0 = TreeNode(0)
    node1 = TreeNode(1)
    node2 = TreeNode(2)
    node3 = TreeNode(3)
    node4 = TreeNode(4)
    node5 = TreeNode(5)
    node6 = TreeNode(6)
    node7 = TreeNode(7)
    node8 = TreeNode(8)
    node9 = TreeNode(9)
    node0.left = node1
    node1.left = node3
    node3.left = node7
    node3.right = node8
    node1.right = node4
    node4.left = node9
    node0.right = node2
    node2.left = node5
    node2.right = node6

    s = Solution()
    result = s.inorderTraversal_iterative(node0)