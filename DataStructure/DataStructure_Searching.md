常用查找数据结构与算法
======================

# 基本概念

查找（Searching）就是根据给定的某个值，在查找表中确定一个其关键字等于给定值的数据元素（或记录）。

查找表按照操作方式可分为：

1. 静态查找表（Static Search Table）：只做查找操作的查找表。它的主要操作是：
    - 查询某个“特定的”数据元素是否在表中
    - 检索某个“特定的”数据元素和各种属性

2. 动态查找表（Dynamic Search Table）：在查找中同时进行插入或删除等操作：
    - 查找时插入数据
    - 查找时删除数据

# 无序表查找

在数据不排序的线性查找，遍历数据元素。

算法分析：最好情况是第一个位置就找到了，为O(1)；最坏情况在最后一个位置找到，为O(n)， 平均查找次数为 (n+1)/2, **时间复杂度为O(n)**

```python
def sequential_search(lst, key):
    length = len(lst)
    for i in range(length):
        if lst[i] == key:
            return i
        else:
            return False

if __name__ == '__main__':
    l = [1,5,8,124,22,54,7,99,300,222]
    result = sequential_search(l, 123)
    print result
```

# 有序表查找

数据按某种方式进行过排序

## 二分查找 Binary Search

算法内容：在查找表中不断取中间元素与查找值进行比较，以二分之一的倍率进行表范围的缩小。时间复杂度：O(logn)

``` python
def binary_search(lst, key):
    low, high = 0, len(lst)-1
    while low < high:
        mid = (low + high) / 2
        if key < lst[mid]:
            high = mid - 1
        elif key > lst[mid]:
            low = mid + 1
        else:
            return mid
    return False

if __name__ == '__main__':
    l = [1, 5, 7, 8, 22, 54, 99, 123, 200, 222, 444]
    result = binary_search(l, 123)
    print result
```

## 插值查找

插值查找是二分查找演化而来，相比于二分查找(折半),该算法考虑的是每次折的时候折多少，即不一定是1/2。在二分查找中mid=(low+high)/2=low+1/2*(high-low)，插值查找就是对1/2(系数,或者说比例)进行改变，它将1/2变成 (key - array[low])/(array[high] - array[low]),其实就是计算线性比例。

时间复杂度：O(logn)

_ note: 因为插值查找是依赖线性比例的，如果当前数组分布不是均匀的，那么该算法就不合适。_

``` python
def interpolate_search(lst, key):
    low, high = 0, len(lst)-1
    while low < high:
        mid = low + (high - low) * (key - lst[low])/(lst[high] - lst[low])
        if key < lst[mid]:
            high = mid - 1
        elif key > lst[mid]:
            low = mid + 1
        else:
            return mid
    return False

if __name__ == '__main__':
    l = [1, 5, 7, 8, 22, 54, 99, 123, 200, 222, 444]
    result = binary_search(l, 123)
    print result
```

## 斐波那契查找

查找算法：在斐波那契数列找一个等于略大于查找表中元素个数的数F(n)，将原查找表扩展为长度为F(n)(如果要补充元素，则补充重复最后一个元素，直到满足数组元素个数为F(n)个元素)，完成后进行斐波那契分割，即F(n)个元素分割为前半部分F(n-1)个元素，后半部分F(n-2)个元素，找出要查找的元素在那一部分并递归，直到找到。
时间复杂度：O(logn)，平均性能优于二分查找。

**利用斐波那契数列的性质，黄金分割的原理来确定mid的位置**

``` python
```

# 线性索引查找

对于海量的无序数据，为了提高查找速度，一般会为其构造索引表。
索引就是把一个关键字与它相对应的记录进行关联的过程。
一个索引由若干个索引项构成，每个索引项至少包含关键字和其对应的记录在存储器中的位置等信息。

索引按照结构可以分为：线性索引、树形索引和多级索引。
线性索引：将索引项的集合通过线性结构来组织，也叫索引表。

线性索引可分为：稠密索引、分块索引和倒排索引

## 稠密索引

## 分块索引

## 倒排索引

# 二叉排序树

二叉排序树又称为二叉查找树。它或者是一颗空树，或者是具有下列性质的二叉树：

- 若它的左子树不为空，则左子树上所有节点的值均小于它的根结构的值；
- 若它的右子树不为空，则右子树上所有节点的值均大于它的根结构的值；
- 它的左、右子树也分别为二叉排序树。

![BSTPic](assets/DataStructure_Searching-ca306.png)

二叉排序树的操作：

- 查找：对比节点的值和关键字，相等则表明找到了；小了则往节点的左子树去找，大了则往右子树去找，这么递归下去，最后返回布尔值或找到的节点。
- 插入：从根节点开始逐个与关键字进行对比，小了去左边，大了去右边，碰到子树为空的情况就将新的节点链接。
- 删除：如果要删除的节点是叶子，直接删；如果只有左子树或只有右子树，则删除节点后，将子树链接到父节点即可；如果同时有左右子树，则可以将二叉排序树进行中序遍历，取将要被删除的节点的前驱或者后继节点替代这个被删除的节点的位置。

```python
class BSTNode:
    """
    定义一个二叉树节点类。
    以讨论算法为主，忽略了一些诸如对数据类型进行判断的问题。
    """
    def __init__(self, data, left=None, right=None):
        """
        初始化
        :param data: 节点储存的数据
        :param left: 节点左子树
        :param right: 节点右子树
        """
        self.data = data
        self.left = left
        self.right = right


class BinarySortTree:
    """
    基于BSTNode类的二叉排序树。维护一个根节点的指针。
    """
    def __init__(self):
        self._root = None

    def is_empty(self):
        return self._root is None

    def search(self, key):
        """
        关键码检索
        :param key: 关键码
        :return: 查询节点或None
        """
        bt = self._root
        while bt:
            entry = bt.data
            if key < entry:
                bt = bt.left
            elif key > entry:
                bt = bt.right
            else:
                return entry
        return None

    def insert(self, key):
        """
        插入操作
        :param key:关键码
        :return: 布尔值
        """
        bt = self._root
        if not bt:
            self._root = BSTNode(key)
            return
        while True:
            entry = bt.data
            if key < entry:
                if bt.left is None:
                    bt.left = BSTNode(key)
                    return
                bt = bt.left
            elif key > entry:
                if bt.right is None:
                    bt.right = BSTNode(key)
                    return
                bt = bt.right
            else:
                bt.data = key
                return

    def delete(self, key):
        """
        二叉排序树最复杂的方法
        :param key: 关键码
        :return: 布尔值
        """
        p, q = None, self._root     # 维持p为q的父节点，用于后面的链接操作
        if not q:
            print("空树！")
            return
        while q and q.data != key:
            p = q
            if key < q.data:
                q = q.left
            else:
                q = q.right
            if not q:               # 当树中没有关键码key时，结束退出。
                return
        # 上面已将找到了要删除的节点，用q引用。而p则是q的父节点或者None（q为根节点时）。
        if not q.left:
            if p is None:
                self._root = q.right
            elif q is p.left:
                p.left = q.right
            else:
                p.right = q.right
            return
        # 查找节点q的左子树的最右节点，将q的右子树链接为该节点的右子树
        # 该方法可能会增大树的深度，效率并不算高。可以设计其它的方法。
        r = q.left
        while r.right:
            r = r.right
        r.right = q.right
        if p is None:
            self._root = q.left
        elif p.left is q:
            p.left = q.left
        else:
            p.right = q.left

    def __iter__(self):
        """
        实现二叉树的中序遍历算法,
        展示我们创建的二叉排序树.
        直接使用python内置的列表作为一个栈。
        :return: data
        """
        stack = []
        node = self._root
        while node or stack:
            while node:
                stack.append(node)
                node = node.left
            node = stack.pop()
            yield node.data
            node = node.right


if __name__ == '__main__':
    lis = [62, 58, 88, 48, 73, 99, 35, 51, 93, 29, 37, 49, 56, 36, 50]
    bs_tree = BinarySortTree()
    for i in range(len(lis)):
        bs_tree.insert(lis[i])
    # bs_tree.insert(100)
    bs_tree.delete(58)
    for i in bs_tree:
        print(i, end=" ")
    # print("\n", bs_tree.search(4))

```

二叉排序树总结：

二叉排序树以链式进行存储，保持了链接结构在插入和删除操作上的优点。

在极端情况下，查询次数为1，但最大操作次数不会超过树的深度。也就是说，二叉排序树的查找性能取决于二叉排序树的形状，也就引申出了后面的平衡二叉树。

给定一个元素集合，可以构造不同的二叉排序树，当它同时是一个完全二叉树的时候，查找的时间复杂度为O(log(n))，近似于二分查找。

当出现最极端的斜树时，其时间复杂度为O(n)，等同于顺序查找，效果最差。

# 平衡二叉树

# 多路查找树 B树

## 2-3树

## 3-4树

## B树

## B+树

# 散列表

散列表：所有的元素之间没有任何关系。元素的存储位置，是利用元素的关键字通过某个函数直接计算出来的。这个一一对应的关系函数称为散列函数或Hash函数。

采用散列技术将记录存储在一块连续的存储空间中，称为散列表或哈希表（Hash Table）。关键字对应的存储位置，称为散列地址。

散列表是一种面向查找的存储结构。它最适合求解的问题是查找与给定值相等的记录。但是对于某个关键字能对应很多记录的情况就不适用，比如查找所有的“男”性。也不适合范围查找，比如查找年龄20~30之间的人。排序、最大、最小等也不合适。

因此，**散列表通常用于关键字不重复的数据结构**。比如python的字典数据类型。

设计出一个简单、均匀、存储利用率高的散列函数是散列技术中最关键的问题。
但是，一般散列函数都面临着冲突的问题。
冲突：两个不同的关键字，通过散列函数计算后结果却相同的现象。collision

## 散列函数构造

好的散列函数：计算简单、散列地址分布均匀

1. 直接定址法

  例如取关键字的某个线性函数为散列函数：
  f(key) = a*key + b (a,b为常数）

2. 数字分析法

  抽取关键字里的数字，根据数字的特点进行地址分配

3. 平方取中法

  将关键字的数字求平方，再截取部分

4. 折叠法

  将关键字的数字分割后分别计算，再合并计算，一种玩弄数字的手段。

5. 除留余数法

  最为常见的方法之一。
  对于表长为m的数据集合，散列公式为：
  f(key) = key mod p (p<=m)
  mod：取模（求余数）
  该方法最关键的是p的选择，而且数据量较大的时候，冲突是必然的。一般会选择接近m的质数。
  随机数法
  选择一个随机数，取关键字的随机函数值为它的散列地址。
  f(key) = random(key)

总结，实际情况下根据不同的数据特性采用不同的散列方法，考虑下面一些主要问题：

- 计算散列地址所需的时间
- 关键字的长度
- 散列表的大小
- 关键字的分布情况
- 记录查找的频率

## 处理散列冲突

## 散列表查找实现

## 散列表查找性能分析