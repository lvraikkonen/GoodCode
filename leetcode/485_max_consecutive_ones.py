
def findMaxConsecutiveOnes(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    result = count = 0
    for n in nums:
        if n == 1:
            count += 1
            result = max(result, count)
        else:
            count = 0
    return result

if __name__ == "__main__":
    result = findMaxConsecutiveOnes([1,1,0,0,1,1,1])
    print result