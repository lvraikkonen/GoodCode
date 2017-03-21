# 找出字符串中第一个不重复的字符，并返回位置

from collections import Counter

class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        # 记录每个字符出现次数
        c = Counter(s)
        result = -1
        # 按顺序遍历字符串，找出位置
        for k, v in enumerate(s):
            if c[v] == 1:
                result = k
                break
        return result

if __name__ == '__main__':
    s = Solution()
    result = s.firstUniqChar("iloveleetcode")