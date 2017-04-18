"""
杨辉三角的特点是每一行的第一和最后一个元素是1，其它元素是上一行它左右两个元素之和
"""
class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        if numRows == 0:
            return []
        result = [[1]]
        while numRows > 1:
            result.append([1] + [a+b for a, b in zip(result[-1][:-1], result[-1][1:])] + [1])
            numRows -= 1
        return result

if __name__ == '__main__':
    s = Solution()
    print s.generate(4)