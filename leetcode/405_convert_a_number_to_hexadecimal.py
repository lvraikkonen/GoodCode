class Solution(object):
    def toHex(self, num):
        """
        :type num: int
        :rtype: str
        """
        result = []
        hex_mapping = '0123456789abcdef'
        if num < 0:
            num += 0x100000000
        while num:
            result.append(hex_mapping[num % 16])
            num /= 16
        return ''.join(result[::-1]) if result else '0'

if __name__ == '__main__':
    s = Solution()
    result = s.toHex(26)