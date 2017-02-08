def maxSubArray(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    if nums == None or len(nums) == 0:
        return 0
    
    maximum, sum = nums[0], 0
    for i in range(len(nums)):
        if sum < 0:
            sum = 0
        sum += nums[i]
        maximum = max(maximum, sum)
    
    return maximum


if __name__ == "__main__":
    lst = [-2,1,-3,4,-1,2,1,-5,4]
    result = maxSubArray(lst)