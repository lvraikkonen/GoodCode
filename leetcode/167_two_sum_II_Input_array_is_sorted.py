"""
初始化左指针left指向数组起始，初始化右指针right指向数组结尾。

根据已排序这个特性，

（1）如果numbers[left]与numbers[right]的和tmp小于target，说明应该增加tmp,因此left右移指向一个较大的值。

（2）如果tmp大于target，说明应该减小tmp,因此right左移指向一个较小的值。

（3）tmp等于target，则找到，返回left+1和right+1。（注意以1为起始下标）

时间复杂度O(n): 扫一遍

空间复杂度O(1)"""

def twoSum(self, numbers, target):
    """
    :type numbers: List[int]
    :type target: int
    :rtype: List[int]
    """
    left, right = 0, len(numbers)-1
    while left < right:
        tmp = numbers[left] + numbers[right]
        if tmp == target:
            return [left+1, right+1]
        elif tmp > target:
            right -= 1
        else:
            left += 1