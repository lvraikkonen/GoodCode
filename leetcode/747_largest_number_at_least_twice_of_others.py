from __future__ import print_function

class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # # brute force
        # max_element = max(nums)
        # if all(max_element >= 2*x for x in nums if x != max_element):
        #     return nums.index(max_element)
        # return -1
        count = 0
        max1 = max2 = float('-inf')
        for x in nums:
            count += 1
            if x > max2:
                if x >= max1:
                    max1, max2 = x, max1
                else:
                    max2 = x
        if count >= 2:
            n2 = max2
            if max1 >= n2*2:
                return nums.index(max1)
            else:
                return -1
        else:
            return nums.index(max1)
        

if __name__ == '__main__':
    s = Solution()
    nums = [3, 6, 1, 0]
    result = s.dominantIndex(nums)
    print(result)