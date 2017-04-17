class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        nums1.extend(nums2)
        nums1 = sorted(nums1)
        l = len(nums1)
        if l % 2 == 1:
            pos = l/2
            return nums1[pos]
        else:
            li, ri = l/2-1, (l+2)/2-1
            return (nums1[li] + nums1[ri]) / 2.0

if __name__ == '__main__':
    s = Solution()
    print s.findMedianSortedArrays([1,3], [2,4])