from __future__ import print_function
from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Tree(object):
    def __init__(self, root=None):
        self.root = root
    
    def __repr__(self):
        left = None if self.root.left is None else self.root.left.val
        right = None if self.root.right is None else self.root.right.val
        return '(D:{}, L:{}, R:{})'.format(self.root.val, left, right)
    
    def build_binary_tree(self, sequence):
        """
        build tree from sequence
        return root
        """
        if type(sequence) != list:
            print("Illegal data type, please input list.")
        node_data = iter(sequence)
        self.root = TreeNode(next(node_data))
        queue = deque([self.root])
        while True:
            head_node = queue.popleft()
            try:
                head_node.left = TreeNode(next(node_data))
                queue.append(head_node.left)
                head_node.right = TreeNode(next(node_data))
                queue.append(head_node.right)
            except StopIteration:
                break
        return self.root


class Solution(object):
    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
        if not root:
            return False
        queue, candidate_val_set = deque([root]), set()
        while queue:
            node = queue.popleft()
            if k - node.val in candidate_val_set:
                return True
            candidate_val_set.add(node.val)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        return False


if __name__ == '__main__':
    s = Solution()
    num = [5,3,6,2,4,None,7]
    k = 9
    t = Tree()
    root = t.build_binary_tree(num)
    s.findTarget(root, k)