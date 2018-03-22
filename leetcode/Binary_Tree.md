二叉树
=================

## 二叉树的构建

``` python
from __future__ import print_function
from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# Definition of a Tree
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
```


## 二叉树的遍历

这里总结的二叉树遍历分为两大类：

- 深度优先（depth-first traversal）
- 广度优先（breadth-first traversal）

其中深度优先包括三种类型：

- PreOrder traversal：以“父节点-左子节点-右子节点”为顺序
- InOrder traversal：以“左子节点-父节点-右子节点”为顺序
- PostOrder traversal：以“左子节点-右子节点-父节点”为顺序

广度优先只包括一种类型：

- LevelOrder traversal：从上到下每层从左到右顺序

## 深度优先搜索(Depth First Search)

深度优先搜索(Depth First Search)是沿着树的深度遍历树的节点，尽可能深的搜索树的分支。

## 广度优先搜索(Breadth First Search)

广度优先搜索(Breadth First Search),又叫宽度优先搜索或横向优先搜索，是从根结点开始沿着树的宽度搜索遍历

## 递归实现

## 非递归实现

### DFS深度搜索算法

- 非递归前序遍历：访问左结点，保存左结点，使用栈。
- 非递归中序遍历：遇到结点入栈，遍历左子树；遍历完左子树，从栈定弹出结点，遍历右子树，使用栈。
- 非递归后序遍历：栈不空当前结点也不空，沿着左路下降入栈，如果从左边返回的然后处理邮编，如果从右边返回，访问该节点，使用栈。

### BFS宽度搜索算法

- 非递归层序遍历：使用队列。


## 二叉搜索树 BST

## 堆 Heap

### 堆的应用

## 优先队列 Priority Queue