def romanToInt(s):
    """
    :type s: str
    :rtype: int
    """
    num_map = {"I": 1, "V": 5, "X": 10, "L": 50, "C":100, "D": 500, "M": 1000}
    result = 0
    for i in reversed(range(len(s))):
        if i == len(s)-1 or num_map[s[i]] >= num_map[s[i+1]]:
            result += num_map[s[i]]
        else:
            result -= num_map[s[i]]
    return result

class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
        小的数字（限于 I、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9
        """
        roman_map = {"I": 1, "V": 5, "X": 10, "L": 50, "C":100, "D": 500, "M": 1000}
        result = 0
        last = 0
        for i in range(len(s)):
            cur = roman_map[s[i]]
            if i > 0 and cur > last:
                result -= last
                result += cur - last
            else:
                result += cur
            last = cur
        return result

if __name__ == '__main__':
    s = Solution()
    print s.romanToInt('LXXXIV')