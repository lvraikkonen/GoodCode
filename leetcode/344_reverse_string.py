class Solution(object):
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        lst = []
        lst.extend(s)
        length = len(lst)
        for i in range(0, length/2):
            lst[i], lst[length-1-i] = lst[length-1-i], lst[i]
        return ''.join(lst)