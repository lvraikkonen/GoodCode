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


if __name__ == "__main__":
    result = removeElement([3,2,2,3], 3)
    print result