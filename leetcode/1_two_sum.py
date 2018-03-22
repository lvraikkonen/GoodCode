# hash table
def two_sum_hashTable(nums, target):
    d = {} # store index of each item
    for idx, num in enumerate(nums):
        if target-num in d: # find paired num in exist dict
            return [d[target - num], idx]
        d[num] = idx

# two pointer
def two_sum_twoPointer(nums, target):
    nums_sorted = sorted((num, i) for i, num in enumerate(nums))
    left, right = 0, len(nums)-1
    while left < right:
        val_left, idx_left = nums_sorted[left]
        val_right, idx_right = nums_sorted[right]
        if val_left + val_right == target:
            return [idx_left, idx_right]
        elif val_left + val_right > target:
            right -= 1
        else:
            left += 1
    return [-1, -1]

if __name__ == "__main__":
    result = two_sum_hashTable([1,3,3], 6)
    print result
