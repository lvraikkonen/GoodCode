# Binary Search
"""
if nums[mid] > nums[start]:
  # mid 在左上
else:
  # mid 在右下
"""

def search(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    if not nums:
        return -1
    start, end = 0, len(nums)-1
    while start+1 < end:
        mid = start + (end - start) / 2
        if nums[mid] == target:
            return mid
        elif nums[mid] > nums[start]:
            # 左边有序， 在左边
            if target >= nums[start] and target <= nums[mid]:
                end = mid
            # 在右边
            else:
                start = mid
        else:
            # 右边有序，在右边
            if target >= nums[mid] and target <= nums[end]:
                start = mid
            # 在左边
            else:
                end = mid
    
    if nums[start] == target:
        return start
    if nums[end] == target:
        return end
    return -1


if __name__ == "__main__":
    lst = [4, 5, 6, 0, 1, 2, 3]
    result = search(lst, 1)