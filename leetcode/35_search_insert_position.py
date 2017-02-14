# binary search
def searchInsert(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    left, right = 0, len(nums) # 有可能插入位置在列表尾端
    while left < right:
        mid = (left + right) / 2
        if nums[mid] < target:
            left = mid + 1
        else:
            right = mid
    return left

if __name__ == "__main__":
    result = searchInsert([1,3,5,6], 7)
    print result
