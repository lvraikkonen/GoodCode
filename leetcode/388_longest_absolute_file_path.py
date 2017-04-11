"""
给定一个以上述格式表示的文件系统字符串
返回其中包含的最长绝对路径的长度
如果文件系统中不包含文件，返回0

解法： '\n'与'\t'为特殊字符，分别只占一个字符

用哈希表来建立深度和当前深度的绝对路径长度之间的映射，
当前深度下的文件的绝对路径就是文件名长度加上哈希表中当前深度对应的长度
"""
class Solution(object):
    def lengthLongestPath_clean(self, input):
        """
        :type input: str
        :rtype: int
        """
        maxlen = 0
        pathlen = {0: 0}
        for line in input.splitlines():
            name = line.lstrip('\t')
            depth = len(line) - len(name) # '\t'的数量
            if '.' in name:
                maxlen = max(maxlen, pathlen[depth]+len(name))
            else:
                pathlen[depth+1] = pathlen[depth] + len(name) + 1 # '\n'占1个字符
        return maxlen

if __name__ == '__main__':
    p = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.txt"
    print p
    s = Solution()
    result = s.lengthLongestPath_clean(p)
    print result