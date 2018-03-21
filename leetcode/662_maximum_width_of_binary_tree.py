# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def widthOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        """
        若某节点的标号为n, 则该节点左右子节点的标号非别为 (2*n)和(2*n+1)
        """
        # 层级遍历
        queue = [(root, 1)]
        result = 0
        while queue:
            width = queue[-1][1] - queue[0][1] + 1
            result = max(result, width)
            nodes_next = []
            for node, n in queue:
                if node.left:
                    nodes_next.append((node.left, 2*n))
                if node.right:
                    nodes_next.append((node.right, 2*n+1))
            queue = nodes_next
        
        return result


if __name__ == '__main__':
    s = Solution()
    node1 = TreeNode(1)
    node2 = TreeNode(2)
    node3 = TreeNode(3)
    node4 = TreeNode(4)
    node5 = TreeNode(5)
    node6 = TreeNode(6)
    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node3.right = node6
    result = s.widthOfBinaryTree(node1)