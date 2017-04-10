# easy method in python
"""按序输出，每个逆序"""
class Solution_easy(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        return ' '.join(w[::-1] for w in s.split())