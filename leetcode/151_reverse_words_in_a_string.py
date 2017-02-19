class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        l = s.strip().split()
        l.reverse()
        return ' '.join(l)