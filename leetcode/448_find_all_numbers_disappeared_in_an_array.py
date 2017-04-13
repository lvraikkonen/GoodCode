# realted problem 442

class Solution(object):
    """
    1 ≤ a[i] ≤ n (n = 数组长度)
    解法：正负号标记法
    遍历数组nums，每个数字作为下标，标记 nums[abs(n)-1] = -1 * abs(nums[abs(n)-1])
    遍历新的数组nums，如果数字为正数，说明没有被上一步标记过，所以为缺失的数字
    """
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for n in nums:
            nums[abs(n)-1] = -abs(nums[abs(n)-1])
        for i, n in enumerate(nums):
            print i+1, n
        result = [i+1 for i, n in enumerate(nums) if n>0]
        return result

if __name__ == '__main__':
    s = Solution()
    result = s.findDisappearedNumbers([4,3,2,7,8,2,3,1])
    print result