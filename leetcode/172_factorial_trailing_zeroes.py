class Solution:
    # @return an integer
    def trailingZeroes(self, n):
        result = 0
        while n >= 5:
            result += n/5
            n /= 5
        return result