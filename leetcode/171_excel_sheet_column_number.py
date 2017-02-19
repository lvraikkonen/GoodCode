class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        result = 0
        index = 0
        for c in s[::-1]:
            result += (ord(c)-ord('A')+1) * (26**index)
            index += 1
        return result