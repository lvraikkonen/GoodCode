""" Two pointer
使用两个指针prev和curr，判断A[curr]是否和A[prev]、A[prev-1]相等，如果相等curr指针继续向后遍历，
直到不相等时，将curr指针指向的值赋值给A[prev+1]，这样多余的数就都被交换到后面去了。
最后prev+1值就是数组的长度
"""
def removeDuplicates(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    if len(nums) <= 2:
        return len(nums)
    prev, curr = 1, 2
    while curr < len(nums):
        if nums[curr] == nums[prev] and nums[curr] == nums[prev-1]:
            curr += 1 # move to next
        else:
            prev += 1
            nums[prev] = nums[curr]
            curr += 1
    return prev + 1

if __name__ == "__main__":
    result = removeDuplicates([1,1,1,2,3])
    print result