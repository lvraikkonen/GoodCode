class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        # two pointer Solution
        VOWELS = ['a', 'e', 'i', 'o', 'u']
        left, right = 0, len(s)-1
        ls = list(s)
        while True:
            while left < len(ls) and ls[left].lower() not in VOWELS:
                left += 1
            while right >= 0 and ls[right].lower() not in VOWELS:
                right -= 1
            if left >= right:
                break
            ls[left], ls[right] = ls[right], ls[left]
            left, right = left+1, right-1
        return ''.join(ls)

if __name__ == '__main__':
    s = Solution()
    result = s.reverseVowels('leetcode')
