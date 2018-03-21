class Solution(object):
    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        isPalindrome = lambda s: s == s[::-1]
        remove1Char_index = lambda s, i: s[:i] + s[i+1:]
        
        l, r = 0, len(s)-1
        while l < r:
            if s[l] != s[r]:
                leftpart = remove1Char_index(s, l)
                rightpart = remove1Char_index(s, r)
                return isPalindrome(leftpart) or isPalindrome(rightpart)
            l += 1
            r -= 1
        return True
    
    def validPalindrome1(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # Time: O(n)
        # Space: O(n)
        left, right = 0, len(s) - 1
        while left < right:
            if s[left] != s[right]:
                one, two = s[left:right], s[left + 1:right + 1]
                return one == one[::-1] or two == two[::-1]
            left, right = left + 1, right - 1
        return True


if __name__ == '__main__':
    s = Solution()
    result = s.validPalindrome('abca')
    