"""
给定一个长度为2n的整数数组，将数组分成n组，求每组数的最小值之和的最大值。

整个数组的最小值x和下一个值的min等于x，所以每组值的和最大，应该等于按顺序排列后偶数位置的数之和
"""
class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return sum(sorted(nums)[::2])