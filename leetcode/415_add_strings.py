"""
给定两个以字符串表示的非负整数num1, num2，返回num1与num2的和。

注意：

num1和num2的长度< 5100
num1和num2只包含数字0-9
num1和num2不包含前导0
你不能使用内置的BigInteger库，也不能直接把输入转换为整数。
"""
class Solution(object):
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        # 模拟两个数加法，处理进位
        result = []
        carry = 0
        idx1, idx2 = len(num1), len(num2)
        while idx1 or idx2 or carry:
            digit = carry
            if idx1:
                idx1 -= 1
                digit += int(num1[idx1])
            if idx2:
                idx2 -= 1
                digit += int(num2[idx2])
            carry = digit>9
            result.append(str(digit%10))
        return ''.join(result[::-1])

if __name__ == '__main__':
    s = Solution()
    result = s.addStrings('123','456')