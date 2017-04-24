# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def preorderTraversal__iterative(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []
        node = root
        stack = []
        while node or stack:
            if node:
                result.append(node.val)
                if node.right:
                    stack.append(node.right)
                node = node.left
            else:
                node = stack.pop()
        return result
    
    def preorderTraversal_recursive(self, root):
        if root:
            print root.val
            self.preorderTraversal_recursive(root.left)
            self.preorderTraversal_recursive(root.right)
        

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
    result = s.preorderTraversal_iterative(node0)