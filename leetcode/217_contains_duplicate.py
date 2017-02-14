from collections import Counter

def containsDuplicate(nums):
    """
    :type nums: List[int]
    :rtype: bool
    """
    n = Counter(nums)
    for k, v in n.items():
        if v > 1:
            return True
    return False