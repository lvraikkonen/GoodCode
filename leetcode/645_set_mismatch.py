from __future__ import print_function

class Solution(object):
    def findErrorNums(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        m = len(nums)
        dmap = [0] * m
        for n in nums:
            if not dmap[n-1]:
                dmap[n-1] = 1
            else:
                return [n, (1+m)*m/2 + n - sum(nums)]
        

if __name__ == '__main__':
    s = Solution()
    nums = [1, 2, 2, 4]
    result = s.findErrorNums(nums)
    print(result)