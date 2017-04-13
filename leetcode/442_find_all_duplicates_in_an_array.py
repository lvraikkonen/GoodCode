# realted problem 448

class Solution(object):
    """
    1 ≤ a[i] ≤ n (n = size of array)
    解法1： 正负号标记法
    遍历数组nums， 每个数字作为下标
    如果nums[abs(数字)-1]小于零，则该数字为重复的
    否则将nums[abs(数字)-1]的值乘以-1作为标记
    """
    def findDuplicates_flag(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = []
        for n in nums:
            if nums[abs(n) - 1] < 0:
                ans.append(abs(n))
            else:
                nums[abs(n) - 1] *= -1
        return ans

if __name__ == '__main__':
    s = Solution()
    result = s.findDuplicates_flag([4,3,2,7,8,2,3,1])
    print result