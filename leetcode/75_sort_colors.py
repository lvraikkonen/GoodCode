class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        """
        左右两个指针用来分隔已经排好的红色和蓝色，中间的指针来遍历元素：

        - 如果是红色，那么和左指针交换，并两个一起向后移，左指针换过来的一定是白色的，因为中指针已经扫描过那些元素了
        - 如果是白色，那么继续向后移
        - 如果是蓝色，那么和右指针交换，右指针向前移，中指针不能后移，因为此时不确定换过来的元素是什么颜色
        """
        left = mid = 0
        right = len(nums) - 1
        while mid <= right:
            if nums[mid] == 0: # red
                nums[mid], nums[left] = nums[left], nums[mid]
                mid += 1
                left += 1
            elif nums[mid] == 1: # white
                mid += 1
            else: # blue
                nums[mid], nums[right] = nums[right], nums[mid]
                right -= 1


if __name__ == '__main__':
    l = [1, 2, 1, 2, 0, 2, 1, 0, 2, 0, 0, 2]
    s = Solution()
    s.sortColors(l)