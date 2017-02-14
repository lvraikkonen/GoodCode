# Description: 选出出现次数大于 ⌊ n/2 ⌋ 的元素

# 投票算法

"""
设定两个变量candidate和count。candidate保存当前可能的候选众数，count保存该候选众数的出现次数。

遍历数组num。

如果当前的数字e与候选众数candidate相同，则将计数count + 1

否则，如果当前的候选众数candidate为空，或者count为0，则将候选众数candidate的值置为e，并将计数count置为1。

否则，将计数count - 1

最终留下的候选众数candidate即为最终答案。

以上算法时间复杂度为O(n)，空间复杂度为O(1)"""
def majorityElement(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    candidate, count = None, 0
    for e in nums:
        if count == 0:
            candidate, count = e, 1
        elif e == candidate:
            count += 1
        else:
            count -= 1
    return candidate

if __name__ == "__main__":
    result = majorityElement([1,5,2,6,1,1,1,3,2,2,2,2,2,2,2])
    print result
