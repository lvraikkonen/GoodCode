class Solution(object):
    def getRow1(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        result = [1] * (rowIndex + 1)
        for i in range(2, rowIndex+1):
            for j in range(1, i):
                result[i - j] += result[i - j - 1]
        return result
    
    def getRow2(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        rowNum = rowIndex + 1
        cur = [1]
        if rowNum == 1:
            return cur
        if rowNum > 1:
            for i in range(rowNum):
                pre = cur
                cur = [1]
                for j in range(i-1):
                    cur.append(pre[j] + pre[j+1])
                cur.append(1)
        return cur

if __name__ == '__main__':
    s = Solution()
    print s.getRow2(4)