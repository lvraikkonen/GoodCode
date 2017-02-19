# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        return self.help(nums, 0, len(nums)-1)
    
    # help function
    def help(self, lst, start, end):
        if start > end:
            return None
        mid = start + (end-start) / 2
        root = TreeNode(lst[mid])
        root.left = self.help(lst, start, mid-1)
        root.right = self.help(lst, mid+1, end)
        return root

if __name__ == "__main__":
    lst = [1,2,3,4,5]
    solution = Solution()
    resultTree = solution.sortedArrayToBST(lst)