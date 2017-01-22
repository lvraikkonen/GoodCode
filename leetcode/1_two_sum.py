def two_sum(nums, target):
    d = {} # store index of each item
    for idx, num in enumerate(nums):
        if target-num in d: # find paired num in exist dict
            return [d[target - num], idx]
        d[num] = idx

if __name__ == "__main__":
    result = two_sum([3,2,4], 6)
    print result
