import collections

def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """

        '''
        为每个字母记出现次数
        出现偶数次的字母数直接累加
        出现奇数次的字母在总数中减1次累加
        最后数字=总数+是否有奇数次出现字母
        '''
        ans, odd = 0, 0
        cnt = collections.Counter(s)
        for c in cnt:
            ans += cnt[c]
            if cnt[c] % 2 == 1:
                ans -= 1
                odd += 1
        return ans + (odd > 0)
