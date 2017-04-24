""" 暴力穷举法
记area的平方根为sqrt
从int(sqrt) 向 1 递减枚举宽度W，若area % W == 0，则L = area / W
"""
import math

class Solution(object):
    def constructRectangle(self, area):
        """
        :type area: int
        :rtype: List[int]
        """
        sq = int(math.sqrt(area))
        L, W = area, 1
        for x in range(sq, 0, -1):
            if area % x == 0:
                L, W = area/x, x
                break
        return [L, W]

if __name__ == '__main__':
    s = Solution()
    area = 36
    print s.constructRectangle(area)