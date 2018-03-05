from __future__ import print_function

class Solution(object):
    def letterCasePermutation(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        if not S:
            return [S]
        rest = self.letterCasePermutation(S[1:])
        if S[0].isalpha():
            tmp = [S[0].lower() + s for s in rest] + [S[0].upper() + s for s in rest]
            return tmp
        return [S[0] + s for s in rest]
        

if __name__ == '__main__':
    s = Solution()
    S = "a1b2"
    result = s.letterCasePermutation(S)
    print(result)