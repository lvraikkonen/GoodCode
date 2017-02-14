# simple solution 首先排序，然后比较相邻两个元素，如果不等，就返回
def singleNumber_simple(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    nums.sort()
    for i in range(1, len(nums), 2):
        if nums[i] != nums[i-1]:
            return nums[i-1]
    return nums[-1] 

# XOR O(n)
# A XOR A = 0 XOR操作可交换
def singleNumber_XOR(nums):
    result = 0
    for i in range(len(nums)):
        result ^= nums[i]
    return result


if __name__ == "__main__":
    result = singleNumber_XOR([3,3,4,4,5])
    print result
