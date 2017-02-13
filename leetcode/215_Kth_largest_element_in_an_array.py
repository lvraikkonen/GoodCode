import random


# Method 1 (Simple Solution) Sort O(nlogn)
def findKthLargest_tricky(self, nums, k):
    """
    :type nums: List[int]
    :type k: int
    :rtype: int
    """
    return sorted(nums, reverse=True)[k - 1]

# Method 2 MaxHeap

# Method 3 quickselect algorithm O(n)
def findKthLargest_quickSelect(nums, k):
    """
    :type nums: List[int]
    :type k: int
    :rtype: int
    """
    pivot = random.choice(nums)
    nums1, nums2 = [], []
    for num in nums:
        if num > pivot:
            nums1.append(num)
        elif num < pivot:
            nums2.append(num)
    if k <= len(nums1):
        return findKthLargest(nums1, k)
    if k > len(nums) - len(nums2):
        return findKthLargest(nums2, k - (len(nums) - len(nums2)))
    return pivot

if __name__ == "__main__":
    result = findKthLargest_quickSelect([4,1,2,6,5,3], 5)
    print result