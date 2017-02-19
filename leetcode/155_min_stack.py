# 双列表，分别存储栈值和最小值
class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = []
        self.minData = []

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.data.append(x)
        if len(self.minData)==0 or x <= self.minData[-1]:
            self.minData.append(x)


    def pop(self):
        """
        :rtype: void
        """
        if self.top() == self.getMin():
            self.minData.pop()
        self.data.pop()


    def top(self):
        """
        :rtype: int
        """
        return self.data[-1]


    def getMin(self):
        """
        :rtype: int
        """
        return self.minData[-1]

minStack = MinStack()
minStack.push(2147483646)
print minStack.data, minStack.min_data
minStack.push(2147483646)
print minStack.data, minStack.min_data
minStack.push(2147483647)
print minStack.data, minStack.min_data
print minStack.getMin()#   --> Returns -3.
print minStack.pop()
print minStack.top()#      --> Returns 0.
print minStack.getMin()#   --> Returns -2.
