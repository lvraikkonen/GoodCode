from __future__ import print_function

def removeElement(nums, val):
    """
    :type nums: List[int]
    :type val: int
    :rtype: int
    """
    left, right = 0, len(nums)-1
    while left <= right:
        if nums[left] == val:
            nums[left], nums[right] = nums[right], nums[left]
            right -= 1
        else:
            left += 1
    return right+1

    """
    左右两个指针向中间靠拢，
    左指针找到一个等于val的值，右指针找到第一个不等于val的值，
    把右指针指向的值赋值给左指针。继续向中间靠拢。
    """
    # left, right = 0, len(nums)-1
    # while left <= right:
    #     while left <= right and nums[left] != val:
    #         left += 1
    #     while left <= right and nums[right] == val:
    #         right -= 1
    #     if left < right:
    #         nums[left] = nums[right]
    #         left += 1
    #         right -= 1
    # return right + 1


if __name__ == "__main__":
    result = removeElement([3,2,2,3], 3)
    print(result)