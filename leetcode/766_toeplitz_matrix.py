from __future__ import print_function
import collections

class Solution(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        vmap = collections.defaultdict(set)
        m, n = len(matrix), len(matrix[0])
        for x in range(m):
            for y in range(n):
                vmap[y-x].add(matrix[x][y])
                if len(vmap[y-x]) > 1:
                    return False
        return True

if __name__ == '__main__':
    s = Solution()
    matrix = [[1, 2], [2, 2]]
    result = s.isToeplitzMatrix(matrix)
    print(result)