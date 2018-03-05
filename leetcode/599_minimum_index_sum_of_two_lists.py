from __future__ import print_function

class Solution(object):
    def findRestaurant(self, list1, list2):
        """
        :type list1: List[str]
        :type list2: List[str]
        :rtype: List[str]
        """
        dict1 = {v: i for i, v in enumerate(list1)}
        minSum = len(list1) + len(list2)
        ans = []
        for i, res in enumerate(list2):
            if res not in dict1:
                continue
            currSum = i + dict1[res]
            if currSum < minSum:
                minSum = currSum
                ans = [res]
            elif currSum == minSum:
                ans.append(res)
        return ans

if __name__ == '__main__':
    s = Solution()
    l1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]
    l2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
    result = s.findRestaurant(l1, l2)
    print(result)