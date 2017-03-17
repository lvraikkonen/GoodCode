"""
给定一个整数数组nums，以及一个整数k，找出其中所有差恰好为k的不重复数对。

注意：

1. 数对(i, j) 和 (j, i)算作同一个数对
2. 数组长度不超过10,000
3. 所有整数在范围[-1e7, 1e7]之间
"""


import collections

class Solution(object):
    def findPairs_simple(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        """找出所有的pair, 如果符合条件，计数器加1     O(n^2)"""
        # list all pairs
        count = 0
        for i in range(len(nums)):
            # find pairs
            for j in range(i+1, len(nums)):
                if abs(nums[i] - nums[j]) == k:
                    count += 1
        return count

    def findPairs_map(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        """
        思路：如果k不等于零的话，那就是nums和nums数组每个数加k集合的交，如果k等于零的话，那就统计数组中相同的数字即可
        区分开k=0的情况
        """
        if k < 0:
            return 0
        elif k == 0:
            return sum(v > 1 for v in collections.Counter(nums).values())
        else:
            return len({item for item in nums} & {item+k for item in nums})

    def findPairs_pointer(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if nums is None or len(nums) == 0 or k < 0:
            return 0
        nums.sort()
        count = 0
        left, right = 0, 1
        while right < len(nums):
            if nums[right] - nums[left] < k:
                right += 1
            elif nums[right] - nums[left] > k:
                left += 1
            else:
                # diff is k
                count += 1
                left, right = left+1, right+1
                while left < len(nums) and nums[left] == nums[left-1]:
                    left += 1
                while right < len(nums) and nums[right] == nums[right-1]:
                    right += 1
            if left == right:
                right += 1
        return count


if __name__ == "__main__":
    s = Solution()
    result = s.findPairs_pointer([1,6,4,2,5], 2)