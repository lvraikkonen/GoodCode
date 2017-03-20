# 给定一组24小时制的时间，格式为“小时：分钟”，求任意两组时间中分钟数间隔的最小值。
class Solution(object):
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        # sort
        time_list = sorted(map(int, p.split(":")) for p in timePoints)
        # transform hour to minutes
        lst = [item[0]*60+item[1] for item in time_list]
        # initialize first result as the last-first
        result = abs(lst[-1] - (1440+lst[0]))
        for i in range(len(lst)-1):
            if lst[i+1] - lst[i] < result:
                result = lst[i+1] - lst[i]
        return result

if __name__ == '__main__':
    s = Solution()
    result = s.findMinDifference(["23:59","00:00"])