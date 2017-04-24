class TreeNode(object):
    """Defination for TreeNode."""
    def __init__(self):
        self.data = data
        self.left = None
        self.right = None

# my implementation of BinarySearchTree class
class BinarySearchTree(object):
    """基于TreeNode类的二叉搜索树"""
    def __init__(self, root):
        self.root = root

    def is_empty(self):
        return self.root is None

    def get_root(self):
        return self.root

    def iterative_insert(self, item):
        """
        Function insert(item):
        ======================

        1. If root is None,
          * Create a new node with item as key
          * Make it root.

        2. Else find a new position by comparing it with each node.
          * If item < key of current node, search in the left subtree.
          * If item > key of current node, search in the right subtree.
          * If the values are identical, ignore it.

        3. Once the appropriate position is found,
          * Create a new node with item as key
          * Insert at that position.
        """
        if self.root is None:
            self.root = TreeNode(item)
        else:
            cur_node = self.root
            while cur_node is not None:
                if item < cur_node.data:
                    if cur_node.left is None:
                        cur_node.left = TreeNode(item)
                        return
                    else:
                        cur_node = cur_node.left
                else:
                    if cur_node.right is None:
                        cur_node.right = TreeNode(item)
                        return
                    else:
                        cur_node = cur_node.right

    def remove(self, node, item):
        """Remove an element from bst."""
        if node is None:
            return
        if item < node.data:
            self.remove(node.left, item)
        elif item > node.data:
            self.remove(node.right, item)
        else:
            if node.left is None:
                tmp = node.right
                node = None

            elif node.right is None:
                tmp = node.left
                node = None

            else:
                tmp = self.get_min(node.right)
                node.data = tmp
                node.right = self.remove(node.right, tmp)


    def search(self, node, key):
        if node is None:
            return False
        else:
            if node.data == key:
                return True
            elif node.data < key:
                return self.search(node.right, key)
            else:
                return self.search(node.left, key)

    def size(self, node):
        if node is None:
            return 0
        else:
            return 1 + self.size(node.left) + self.size(node.right)

    """
    二叉树的遍历
    前序遍历：根节点->左子树->右子树
    中序遍历：左子树->根节点->右子树
    后序遍历：左子树->右子树->根节点
    """
    def inorder(self, node):
        """中序遍历"""
        if node:
            self.inorder(node.left)
            print node.data
            self.inorder(node.right)

    def preorder(self, node):
        """前序遍历"""
        if node:
            print node.data
            self.preorder(node.left)
            self.preorder(node.right)

    def postorder(self, node):
        """后序遍历"""
        if node:
            self.postorder(node.left)
            self.postorder(node.right)
            print node.data

    def get_min(self, node):
        if self.is_empty():
            return "Tree is empty"
        else:
            if node.left is None:
                return node.data
            else:
                return self.get_min(node.left)

    def get_max(self, node):
        if self.is_empty():
            return "Tree is empty"
        else:
            if node.right is None:
                return node.data
            else:
                return self.get_max(node.right)
