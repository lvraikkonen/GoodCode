class Solution:
    # @return a string
    def convertToTitle(self, num):
        title = ''
        while num > 0:
            num -= 1
            mod = num % 26
            num /= 26
            title += chr(ord('A') + mod)
        return title[::-1]