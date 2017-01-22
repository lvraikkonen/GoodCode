class Solution(object):
    def fizzBuzz(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        return [('Fizz'*(not x%3)) + 'Buzz'*(not x%5) or str(x) for x in range(1, n+1)]
