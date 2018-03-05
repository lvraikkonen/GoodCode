# 给定一个递增有序的整数数组，其中除一个元素外，剩余元素均出现两次。找出那个单独的元素。

# 注意：你的解法应当满足O(log n)时间和O(1)空间约束。

# 二分查找

from __future__ import print_function

class Solution(object):
    def singleNonDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l, r = 0, len(nums)-1
        while l < r:
            middle = (l + r) / 2
            if nums[middle] == nums[middle-1]:
                if (middle - 1) % 2:
                    r = middle - 2 # 目标在长度为奇数的子数组中
                else:
                    l = middle + 1
            elif nums[middle] == nums[middle+1]:
                if (middle + 1) % 1:
                    l = middle + 2
                else:
                    r = middle - 1
            else:
                return nums[middle]
        return nums[l]
         

if __name__ == '__main__':
    s = Solution()
    nums = [1,1,2,3,3,4,4,8,8]
    result = s.singleNonDuplicate(nums)
    print(result)