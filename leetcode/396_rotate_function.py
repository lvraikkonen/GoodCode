"""
给定一个整数数组A，其长度为n。

假设Bk是将数组A顺时针旋转k个位置得到的数组，我们定义一个“旋转函数”F如下所示：

F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

计算F(0), F(1), ..., F(n-1)的最大值
"""

"""
解法：归纳规律
先把具体的数字抽象为A,B,C,D，那么我们可以得到：

F(0) = 0A + 1B + 2C +3D

F(1) = 0D + 1A + 2B +3C

F(2) = 0C + 1D + 2A +3B

F(3) = 0B + 1C + 2D +3A

那么，我们通过仔细观察，我们可以得出下面的规律：

F(1) = F(0) + sum - 4D

F(2) = F(1) + sum - 4C

F(3) = F(2) + sum - 4B

那么我们就找到规律了, F(i) = F(i-1) + sum - n*A[n-i]
"""

class Solution(object):
    def maxRotateFunction(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        size = len(A)
        sums = sum(A)
        # F(0) = 0A + 1B + 2C + 3D
        fn = sum(k*v for k,v in enumerate(A))
        result = fn
        for x in range(size-1, 0, -1):
            fn += sums - size*A[x]
            result = max(result, fn)
        return result

if __name__ == '__main__':
    A = [4, 3, 2, 6]
    s = Solution()
    result = s.maxRotateFunction(A)
    print result
