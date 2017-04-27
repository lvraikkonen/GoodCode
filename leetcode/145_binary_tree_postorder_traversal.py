# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def postorderTraversal(self, node):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if node is None:
            return []
        stack = []
        result = []
        lastNodeVisited = None
        while stack or node:
            if node:
                stack.append(node)
                node = node.left
            else:
                peekNode = stack[-1]
                if peekNode.right and lastNodeVisited != peekNode.right:
                    node = peekNode.right
                else:
                    result.append(peekNode.val)
                    lastNodeVisited = stack.pop()
        return result
        
    
    def postorderTraversal_recursive(self, root):
        if root:
            self.postorderTraversal_recursive(root.left)
            self.postorderTraversal_recursive(root.right)
            print root.val


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
    result = s.postorderTraversal(node0)
    print result