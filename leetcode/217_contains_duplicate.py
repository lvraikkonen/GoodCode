from collections import Counter

def containsDuplicate_counter(nums):
    """
    :type nums: List[int]
    :rtype: bool
    """
    n = Counter(nums)
    for k, v in n.items():
        if v > 1:
            return True
    return False

def containsDuplicate_set(nums):
    """
    :type nums: List[int]
    :rtype: bool
    """
    distinct_nums = set()
    for num in nums:
        if num in distinct_nums:
            return True
        distinct_nums.add(num)
    return False

if __name__ == "__main__":
    result = containsDuplicate_set([1,2,3,3])
    print result