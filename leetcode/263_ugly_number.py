"""
编写程序判断一个给定的数字是否为“丑陋数” ugly number
丑陋数是指只包含质因子2, 3, 5的正整数。例如，6, 8是丑陋数而14不是，因为它包含额外的质因子7

注意，数字1也被视为丑陋数
"""

class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0:
            return False
        for x in [2, 3, 5]:
            while num % x == 0:
                num /= x
        return num == 1

if __name__ == '__main__':
    s = Solution()
    print s.isUgly(8)