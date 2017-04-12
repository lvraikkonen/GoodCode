"""
解法： 滑动窗口

变量start和end分别记录子串的起点和终点

从左向右逐字符遍历原始字符串，每次将end + 1

字典countDict存储当前子串中各字符的个数

当新增字符c的计数 > 1时，将s[start]在字典中的计数 - 1, 向右移动起点start，直到countDict[c]不大于1为止

更新最大长度
"""

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        result, start, end = 0, 0, 0
        countDict = {}
        for c in s:
            end += 1
            countDict[c] = countDict.get(c, 0) + 1
            while countDict[c] > 1:
                countDict[s[start]] -= 1
                start += 1
            result = max(result, end-start)
        return result

if __name__ == '__main__':
    s = "pwwkew"
    result = Solution().lengthOfLongestSubstring(s)
    print result