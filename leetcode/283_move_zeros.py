class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        zeroNum = 0
        for i in range(len(nums)):
            if nums[i]==0:
                zeroNum += 1
            else:
                nums[i-zeroNum] = nums[i]
        for i in range(zeroNum):
            nums[len(nums) - zeroNum + i] = 0