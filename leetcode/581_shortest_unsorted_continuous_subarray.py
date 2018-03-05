from __future__ import print_function

class Solution(object):
    def findUnsortedSubarray_sortedMethod(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # O(nlogn)
        nums_sorted = sorted(nums)
        s = e = -1
        for i in range(len(nums)):
            # find mismatched index position
            if nums[i] != nums_sorted[i]:
                if s == -1:
                    s = i
                e = i
        if e!=s:
            return e - s + 1
        else:
            return 0
    
    def findUnsortedSubarray_noExtraSpace(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # O(n)
        min_val = 9999
        max_val = -9999
        flag = False
        for i in range(1, len(nums)):
            if nums[i] < nums[i-1]:
                flag = True
            if flag:
                min_val = min(min_val, nums[i])
        flag = False
        for i in range(len(nums)-2, -1, -1):
            if nums[i] > nums[i+1]:
                flag = True
            if flag:
                max_val = max(max_val, nums[i])
        l, r = 0, len(nums)-1
        while l < len(nums):
            if min_val < nums[l]:
                break
            l += 1
        while r >= 0:
            if max_val > nums[r]:
                break
            r -= 1
        return r-l+1 if r-l>=0 else 0


if __name__ == '__main__':
    l = [2, 1]
    s = Solution()
    result = s.findUnsortedSubarray_noExtraSpace(l)
    print(result)