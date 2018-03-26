from collections import deque

"""
- 方法一：最直观的，每次从起点i遍历一遍窗口长度j = i, i + k，找最大值，两层for循环，时间复杂度O(n * k)
- 方法二：维护一个hash heap，每次移动，加入右边元素O(logk)，减去左边元素O(logk)，返回maxheap中的最大值O(1)，时间复杂度为O(n * logk)
- 方法三：使用Deque，维护一个递减的deque，时间复杂度为O(n)
- 方法四：类似最小栈解法，维护两个队列
"""

class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if not nums:
            return []
        queue = deque()
        result = []
        for i in range(len(nums)):
            # 如果新来的数据比队尾元素大，则把队尾元素弹出，直至队列为空
            while queue and nums[queue[-1]] <= nums[i]:
                queue.pop()
            queue.append(i)
            # 如果队列头部元素的下标是窗口最左边数的下标(窗口后移一位)，则扔掉
            if queue[0] == i - k:
                queue.popleft()
            # 队列头部就是最大的元素
            if i >= k - 1:
                result.append(nums[queue[0]])
        return result

    def maxSlidingWindow_simple(self, nums, k):
        if not nums:
            return []
        queue = deque()
        result = []
        for num in nums:
            if len(queue) < k:
                queue.append(num)
            else:
                result.append(max(queue))
                queue.popleft()
                queue.append(num)
        result.append(max(queue))
        return result



class MaxQueue:
    def __init__(self):
        self.max_q = deque()
        self.q = deque()
    
    def enqueue(self, item):
        while self.max_q and self.max_q[-1] < item:
            self.max_q.pop()

        self.q.append(item)
        self.max_q.append(item)
        
    def dequeue(self):
        popped = self.q.popleft()
        
        if popped == self.max_q[0]:
            self.max_q.popleft()
            
        return popped
        
    def get_max(self):
        if self.max_q: return self.max_q[0]
        else: return None
        

class Solution1:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {integer[]}
    def maxSlidingWindow(self, nums, k):
        if not nums:
            return []

        q = MaxQueue()
        # first k element
        for num in nums[:k]:
            q.enqueue(num)
        
        results = []
        cur_max = q.get_max()
        results.append(cur_max)
        
        for i in range(k, len(nums)):
            cur_num = nums[i]
            q.dequeue()
            q.enqueue(cur_num)
            
            results.append(q.get_max())
        
        return results



if __name__ == '__main__':
    nums = [9,8,7,6,5,4,3,2,1]
    k = 3
    s = Solution()
    result = s.maxSlidingWindow(nums, k)