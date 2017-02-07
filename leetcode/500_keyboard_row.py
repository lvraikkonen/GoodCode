class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        rs = map(set, ['qwertyuiop','asdfghjkl','zxcvbnm'])
        ans = []
        for word in words:
            wset = set(word.lower())
            # set: s <= t  测试是否 s 中的每一个元素都在 t 中  
            if any(wset <= rset for rset in rs):
                ans.append(word)
        return ans