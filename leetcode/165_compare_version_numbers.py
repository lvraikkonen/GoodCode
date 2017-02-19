class Solution:
    # @param version1, a string
    # @param version2, a string
    # @return an integer
    def compareVersion(self, version1, version2):
        v1 = version1.split('.')
        v2 = version2.split('.')
        max_len = max(len(v1), len(v2))
        for i in range(max_len):
            v1Token, v2Token = 0, 0
            if i < len(v1):
                v1Token = int(v1[i])
            if i < len(v2):
                v2Token = int(v2[i])
            if v1Token > v2Token:
                return 1
            if v1Token < v2Token:
                return -1
        return 0