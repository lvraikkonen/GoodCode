# 二叉树序列化和反序列化

"""
1. 序列化
先序遍历二叉树，以','分割值字符串
2. 反序列化
利用栈（Stack），节点栈nstack保存重建二叉树过程中的节点，最大值栈rstack保存当前节点的右孩子允许的最大值。
遍历序列化串，记当前数值为val，新增树节点node = TreeNode(val)；记nstack的栈顶元素为ntop（nstack[-1]）
若val < ntop，则val为ntop的左孩子，令ntop.left = node，并将node压入nstack；将ntop.val压入rstack
否则，val应为右孩子，但其父节点并不一定为ntop：
    记rstack的栈顶元素为rtop，当val > rtop时，执行循环：
        重复弹出nstack，直到ntop不是右孩子为止（nstack[-1] > nstack[-2]条件不成立）
        再次弹出nstack， 并弹出rstack
    上述过程执行完毕后，令ntop.right = node，并将node压入nstack
"""