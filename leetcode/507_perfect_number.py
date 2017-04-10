"""
判断某正整数n是否等于除其本身外所有因子之和
"""
class Solution(object):
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        total, div = 1, 2
        while div * div <= num:
            if num % div == 0:
                total += div
                if div * div != num:
                    total += num / div
            div += 1
        return num > 1 and total == num
    
if __name__ == '__main__':
    n = 28
    s = Solution()
    result = s.checkPerfectNumber(n)