class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        dist = 0
        val = x ^ y
        while(val!=0):
            dist += 1
            val &= val -1
        return dist