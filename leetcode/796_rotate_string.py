class Solution(object):
    def rotateString(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: bool
        """
        if len(A) != len(B):
            return False
        if len(A) == 0 and len(B) == 0:
            return True
        for i in range(len(A)):
            if A[i:] + A[:i] == B:
                return True
        return False


if __name__ == '__main__':
    s = Solution()
    A = B = ""
    result = s.rotateString(A, B)