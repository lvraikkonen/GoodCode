from __future__ import print_function

class Solution(object):
    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = anchor = 0
        for i in range(len(nums)):
            if i and nums[i-1] >= nums[i]: #except first element
                anchor = i
            ans = max(ans, i-anchor+1)
        return ans
        

if __name__ == '__main__':
    s = Solution()
    nums = [1, 3, 5, 4, 7]
    result = s.findLengthOfLCIS(nums)
    print(result)