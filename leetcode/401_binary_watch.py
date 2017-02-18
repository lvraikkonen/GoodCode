# -*- coding:utf-8 -*-

# 枚举小时和分钟，然后判断二进制1的个数是否等于num
def readBinaryWatch(num):
    """
    :type num: int
    :rtype: List[str]
    """
    ans = []
    for h in range(12):
        for m in range(60):
            if (bin(h)+bin(m)).count('1') == num:
                ans.append('%d:%02d' % (h, m))
    return ans

if __name__ == "__main__":
    result = readBinaryWatch(1)
    print result