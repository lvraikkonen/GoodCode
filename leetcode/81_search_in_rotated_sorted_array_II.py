class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        if not nums:
            return False
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = (l + r) / 2
            if nums[mid] == target:
                return True
            while l < mid and nums[l] == nums[mid]:
                l += 1
            while r > mid and nums[r] == nums[mid]:
                r -= 1
            if nums[l] <= nums[mid]:
                # 在左侧
                if nums[l] <= target <= nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
            else:
                if nums[mid] <= target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
        return False


if __name__ == '__main__':
    nums = [4,4,6,7,7,0,1]
    k = 0
    s = Solution()
    result = s.search(nums, k)
