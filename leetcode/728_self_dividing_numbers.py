class Solution(object):
    def selfDividingNumbers(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: List[int]
        """
        # # functional programming
        # def check(num):
        #     digits = set(map(int, str(num)))
        #     if 0 in digits:
        #         return False
        #     return not any(num % d for d in digits)
        
        # return filter(check, range(left, right + 1))

        def check(num):
            digits = set(str(num))
            for d in map(int, digits):
                if d == 0 or num % d > 0:
                    return False
            return True
        
        ans = []
        for n in range(left, right+1):
            if check(n):
                ans.append(n)
        return ans


if __name__ == '__main__':
    s = Solution()
    result = s.selfDividingNumbers(1, 22)