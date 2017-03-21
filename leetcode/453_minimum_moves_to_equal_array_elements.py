# 给定一个长度为n的非空整数数组，计算最少需要多少次移动可以使所有元素相等，一次移动是指将n - 1个元素加1。
class Solution(object):
    def minMoves_BruteForce(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # this Solution will exceed time limit
        # example, [1, 2147483647]
        count = 0
        while True:
            nums_max, nums_min = max(nums), min(nums)
            if nums_max == nums_min:
                break
            nums[nums.index(nums_max)] -= 1
            count += 1
        return count
    
    def minMoves_Math(self, nums):
        return sum(nums) - min(nums) * len(nums)

if __name__ == '__main__':
    s = Solution()
    result = s.minMoves_Math( [1, 2147483647])
    print result