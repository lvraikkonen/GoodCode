"""
happy number，是被这样的过程定义的数字：初始时有一个正整数，
用该整数每位数字的平方之和代替这个整数，重复该过程直至数字变为1（之后不再变化），
或者陷入一个无尽的循环但该循环不包括1。那些能终止于1的数字就称为 happy number。
"""
class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        visited = set()
        while True:
            if n == 1:
                return True
            n = sum(int(i) ** 2 for i in str(n))
            if n in visited:
                return False
            visited.add(n)
    
if __name__ == '__main__':
    s = Solution()
    res = s.isHappy(2)