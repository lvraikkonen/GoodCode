# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {TreeNode}
    # 迭代解法
    def invertTree_iterative(self, root):
        if root is None:
            return None
        queue = [root]
        while queue:
            front = queue.pop(0)
            if front.left:
                queue.append(front.left)
            if front.right:
                queue.append(front.right)
            front.left, front.right = front.right, front.left
        return root
    
    # 递归解法
    def invertTree_recursive(self, root):
        if root is not None:
            root.left, root.right = self.invertTree_recursive(root.right), self.invertTree_recursive(root.left)
        return root


class Queue:
    def __init__(self):
        self.data = collections.deque()
        
    def push(self, x):
        self.data.append(x)
    
    def peek(self):
        return self.data[0]
    
    def pop(self):
        return self.data.popleft()
    
    def size(self):
        return len(self.data)
    
    def empty(self):
        return len(self.data) == 0
        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution2:
    # @param {TreeNode} root
    # @return {TreeNode}
    def invertTree(self, root):
        if root is not None:
            nodes = Queue()
            nodes.push(root)
            while not nodes.empty():
                node = nodes.pop()
                node.left, node.right = node.right, node.left
                if node.left is not None:
                    nodes.push(node.left)
                if node.right is not None:
                    nodes.push(node.right)
        
        return root
  
# Time:  O(n)
# Space: O(h)
# Stack solution.
class Solution3:
    # @param {TreeNode} root
    # @return {TreeNode}
    def invertTree(self, root):
        if root is not None:
            nodes = []
            nodes.append(root)
            while nodes:
                node = nodes.pop()
                node.left, node.right = node.right, node.left
                if node.left is not None:
                    nodes.append(node.left)
                if node.right is not None:
                    nodes.append(node.right)
        
        return root


if __name__ == "__main__":
    root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left.left = TreeNode(1)
    root.left.right = TreeNode(3)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(9)

    solution = Solution()
    tree = solution.invertTree_recursive(root)