def containsNearbyDuplicate(nums, k):
    """
    :type nums: List[int]
    :type k: int
    :rtype: bool
    """
    distinct_nums_dict = {}
    for i, num in enumerate(nums):
        if num in distinct_nums_dict and i - distinct_nums_dict[num] <= k:
            return True
        distinct_nums_dict[num] = i
    return False

if __name__ == "__main__":
    result = containsDuplicate_set([1,2,3,3])
    print result