class Solution:
# @param num, a list of integers
# @return a string
    def largestNumber(self, num):
        """
        a=2, b=11, a+b=211, b+a=112 then a+b>b+a
        """
        comp = lambda a,b: 1 if a+b>b+a else -1 if a+b<b+a else 0
        num = map(str, num)
        num.sort(cmp=comp, reverse=True)
        return str(int("".join(num)))


if __name__ == '__main__':
    s = Solution()
    num = [3, 30, 34, 5, 9]
    result = s.largestNumber(num)
    print(result)