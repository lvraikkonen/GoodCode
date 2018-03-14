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
    l, r = 0, len(nums) - 1
    while l <= r:
        mid = (l + r) / 2
        if nums[mid] == target:
            return mid
        elif nums[mid] >= nums[l]:
            # 左边有序
            if nums[l] <= target <= nums[mid]:
                r = mid-1
            else:
                l = mid+1
        else:
            # 右边有序
            if nums[mid] <= target <= nums[r]:
                l = mid+1
            else:
                r = mid-1
    return -1


if __name__ == "__main__":
    lst = [4,5,6,7,0,2]
    result = search(lst, 0)