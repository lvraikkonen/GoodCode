import math

class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 3:
            return 0

        is_prime = [True for _ in range(n)]
        is_prime[0], is_prime[1] = False, False
        for i in range(2, int(math.sqrt(n))+1):
            if is_prime[i]:
                for j in range(i*i, n, i):
                    is_prime[j] = False

        return is_prime.count(True)