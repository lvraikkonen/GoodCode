def thirdMax(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    first = second = third = None
    for n in nums:
        if n > first:
            first, second, third = n, first, second
        elif first > n > second:
            second, third = n, second
        elif second > n > third:
            third = n
    return third if third is not None else first


if __name__ == "__main__":
    result = thirdMax([1,4,4,5])
    print result