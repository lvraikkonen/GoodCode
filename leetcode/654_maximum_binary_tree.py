from __future__ import print_function

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def constructMaximumBinaryTree(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if not nums:
            return None
        max_num = max(nums)
        idx = nums.index(max_num)
        node = TreeNode(max_num)
        node.left = self.constructMaximumBinaryTree(nums[:idx])
        node.right = self.constructMaximumBinaryTree(nums[idx+1:])
        return node


if __name__ == '__main__':
    s = Solution()
    nums = [3,2,1,6,0,5]
    result = s.constructMaximumBinaryTree(nums)
    print(result)