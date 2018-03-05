from __future__ import print_function

class Solution(object):
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        # division and modulus
        m, n = len(nums), len(nums[0])
        if m * n != r * c:
            return nums
        ans = []
        for x in range(r):
            row = []
            for y in range(c):
                row.append(nums[(x * c + y)/ n][(x * c + y) % n])
            ans.append(row)
        return ans
        

if __name__ == '__main__':
    s = Solution()
    nums = [[1,2], [3,4]]
    r, c = 1, 4
    result = s.matrixReshape(nums, r, c)
    print(result)