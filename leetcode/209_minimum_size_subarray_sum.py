from __future__ import print_function

class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        # two pointers
        size = len(nums)
        start, end, sum = 0, 0, 0
        bestAns = size + 1
        while True:
            if sum < s:
                if end >= size:
                    break
                sum += nums[end]
                end += 1
            else:
                if start > end:
                    break
                bestAns = min(bestAns, end-start)
                sum -= nums[start]
                start += 1
        return [0, bestAns][bestAns <= size]
        

if __name__ == '__main__':
    solu = Solution()
    nums = [2,3,1,2,4,3]
    s = 7
    result = solu.minSubArrayLen(s, nums)
    print(result)