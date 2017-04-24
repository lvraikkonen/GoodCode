"""按照字符串中字符出现次数降序输出"""
from collections import Counter

class Solution(object):
    def frequencySort_counter(self, s):
        """
        :type s: str
        :rtype: str
        Counter解法
        """
        if not s:
            return ""
        c1 = Counter(s)
        c1_ordered = c1.most_common()
        result = ""
        for k, v in c1_ordered:
            result += k*v
        return result
    
    def frequencySort_counterSort(self, s):
        """
        :type s: str
        :rtype: str
        """
        c1, c2 = Counter(s), {}
        result = ''
        for k, v in c1.items():
            c2.setdefault(v,[]).append(k*v)
        # {1: ['r', 't'], 2: ['ee']}
        c2_sorted = sorted(c2.items(), key=lambda x: x[0], reverse=True)
        for i in range(len(c2_sorted)):
            result += ''.join(c2_sorted[i][1])
        return result
    
    def frequencySort_hashmap(self, s):
        """
        :type s: str
        :rtype: str
        """
        hashmap = {}
        for chr in s:
            hashmap[chr] = hashmap.get(chr, 0) + 1
        items = hashmap.items()
        items.sort(key = lambda tup: tup[1], reverse = True)
        return ''.join([ch*feq for ch, feq in items])

if __name__ == '__main__':
    st = 'tree'
    s = Solution()
    print s.frequencySort_hashmap(st)