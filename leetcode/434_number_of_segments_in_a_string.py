class Solution(object):
    def countSegments(self, s):
        """
        :type s: str
        :rtype: int
        """
        return sum([s[i] != ' ' and (i==0 or s[i-1] == ' ') for i in range(len(s))])
