class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        Input is guaranteed to be within the range from 1 to 3999
        """
        roman_list = [["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"],
                      ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"],
                      ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"],
                      ["", "M", "MM", "MMM"]]
        roman = ''
        roman += roman_list[3][num / 1000 % 10]
        roman += roman_list[2][num / 100 % 10]
        roman += roman_list[1][num / 10 % 10]
        roman += roman_list[0][num % 10]
        return roman

if __name__ == '__main__':
    s = Solution()
    print s.intToRoman(1000)