import collections

class Solution(object):
    def findLHS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        cnt = collections.Counter(nums)
        ans = 0
        lastKey = lastVal = None
        for key, val in sorted(cnt.items()):
            if lastKey is not None and lastKey+1 == key:
                ans = max(ans, lastVal+val)
            lastKey, lastVal = key, val
        return ans

if __name__ == '__main__':
    s = Solution()
    print s.findLHS([1, 3, 2, 2, 5, 2, 3, 7])
