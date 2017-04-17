"""
给定一个字符串s，若其中的'A'大于1个，或者出现连续的3个或3个以上'L'，返回False，否则返回True
"""
class Solution(object):
    def checkRecord(self, s):
        """
        :type s: str
        :rtype: bool
        """
        return s.count('A') <= 1 and 'LLL' not in s


if __name__ == '__main__':
    s = 'PPALLL'
    print Solution().checkRecord(s)