class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        result = [0] * (num+1)
        before = pow2 = 1
        for i in range(1, num+1):
            if i == pow2:
                before = result[i] = 1
                pow2 <<= 1
            else:
                result[i] = result[before] + 1
                before += 1
        return result

if __name__ == '__main__':
    s = Solution()
    print s.countBits(9)