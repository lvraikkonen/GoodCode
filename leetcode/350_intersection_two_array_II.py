import collections

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        result = []
        counts = collections.Counter(nums1)
        for num in nums2:
            if counts[num] > 0:
                result.append(num)
                counts[num] -= 1
        return result

if __name__ == "__main__":
    s = Solution()
    result = s.intersect([1], [1])
    print result